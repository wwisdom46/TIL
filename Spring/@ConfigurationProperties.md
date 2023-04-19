# ****@ConfigurationProperties****

## 1. ****@ConfigurationProperties 이란?****

- .properties , *.yml 파일에 있는 property를 자바 클래스에 값을 가져와서(바인딩) 사용할 수 있게 해주는 어노테이션
- 스프링부트에서는 운영에 필요한 설정(DB 정보, LOG설정 등등 )들을 *.properties , *.yml 에 써두고 관리
- 이 설정은 key-value 형태로 저장되어 관리하고 있으며 @Value 을 사용하여 바인딩 할 수 있다.

아래와 같은 .yml 파일이 있다고 할 때,

```xml
url.admin = https://www.admin.com
url.mall = https://www.mall.com
```

@Value를 아래와 같이 사용한다.

```kotlin
@Value("\${url.admin}")
private lateinit var adminUrl: String

@Value("\${url.mall}")
private lateinit var mallUrl: String
```

하지만 이렇게 사용할 경우 문자열을 사용하는 것이기 때문에 오타가 날 수 도 있다.

## 개선

1. .properties , *.yml  에서 오토컴플릿을 지원하도록 하기 위한 dependency 추가

```xml
annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
kapt("org.springframework.boot:spring-boot-configuration-processor")
```

1. 클래스 파일 생성
- @ConfigurationProperties 이 좋은 이유
    - 여러 표기법에 대해서 오토로 바인딩해 준다. ( 아래 참고 )

| acme.my-project.person.first-name | properties 와 .yml에 권장되는 표기 방법 |
| --- | --- |
| acme.myProject.person.firstName | 표준 카멜 케이스 문법. |
| acme.my_project.person.first_name | .properties와 .yml 에서 사용가능한 방법
( - 표기법이 더 표준 ) |
| ACME_MYPROJECT_PERSON_FIRSTNAME | 시스템 환경 변수를 사용할 때 권장 |

@Component로 bean을 등록해야 한다.

@ConfigurationProperties에 prefix를 설정한다.

properties 파일에 있는 url.* 에 대하여 바인딩한다.

```kotlin
@ConfigurationProperties(prefix = "url")
@ConstructorBinding
data class UrlProperties(
	val admin: String
	val mall: String
)
```

테스트 코드

```kotlin
@RunWith(SpringRunner::class)
@SpringBootTest
class SpringBootV2ApplicationIntegrationTest {

    @Autowired
    lateinit var ulProperties: UrlProperties

    @Test
    fun givenExternalConfigProps_whenUsedConstructorBinding_thenBindExternalProperties() {
        assertThat(ulProperties).isNotNull
        assertThat(ulProperties.admin).isNotBlank
        assertThat(ulProperties.mall).isNotBlank
    }
}
```

## 한계점

1. @ConfigurationProperties에 대해서만 동작하기 때문에 @Value와 같이 단순하게 사용한 경우에는 해당 configuration에 대해서 metadata가 생성되지 않는다.
2. properties나 yml에 정의만 해놓고 @ConfigurationProperties 클래스를 생성하지 않은 경우에는 해당 configuration에 대해서 metadata가 생성되지 않는다.
3. properties나 yml의 위치하는 모듈과 @ConfigurationProperties 클래스가 위치하는 모듈이 다른 경우에는 해당 configuration에 대해서 metadata가 생성되지 않는다. 소스코드가 돌아가는데는 전혀 문제가 없지만 올바른 설계인지 고민을 한 번 해보는 것이 좋다.

## 참고

[https://www.baeldung.com/kotlin/spring-boot-configurationproperties](https://www.baeldung.com/kotlin/spring-boot-configurationproperties)