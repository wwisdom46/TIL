# 1. Feign Client 란?

- 넷플릭스에서 개발된 Http client blinder
- 인터페이스 상단에 @FeignClient로 선언 후, 약간의 설정값을 넣으면 해당 인터페이스 자체가 http 클라이언트가 되어 서버로 http 요청을 할 수 있음

# 2. Feign 적용 예시

1. build.gradle 의존성 추가

```java
dependencies {
    implementation 'org.springframework.cloud:spring-cloud-starter-feign:1.4.7.RELEASE'
    ...
}
```

2.Main Class에 @EnableFeignClients 추가

- @EnableFeignClients는 root Package에 선언되어 이후에 사용될 @FeignClient 을 찾아 등록하는 역할

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
```

 3. @FeignClient 등록
- @FeignClient를 통해서 interface를 등록
    - name : feignClient의 서비스 이름으로 필수로 작성
    - url : 해당 interface를 통해 요청할 baseUrl
    - qualifier : 해당 interface의 beanName을 등록할 수 있음
    - configuration : 커스터마이징 한 configuration을 넣을 수 있음
    - fallback : interface를 통해 요청하고 에러가 발생했을 때 이후 처리를 등록할 수 있음
- @RequestHeader는 요청 시에 Header를 추가
- @RequestParam은 요청시에 파라미터를 추가
- @RequestBody는 요청시에 body를 통해 데이터를 추가

```java
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "exampleClient", url = "http://localhost:8082")
public interface FeignInterface {
    @GetMapping(value = "/test", produces = "application/json", consumes = "application/json")
    String testMethod(@RequestParam("key") String key);
    
    @PostMapping(value = "/user", produces = "application/json", consumes = "application/json")
    String registUser(@RequestHeader("auth-key") String authKey, @RequestBody SecurityProperties.User user);
}
```

 4. Config 등록
- 굳이 설정하지 않아도 기본 제공하는 기능들과 설정을 해야하만 제공하는 기능들이 있음
    - Retryer : 재시도 알고리즘을 제공
    - ErrorDecoder : Http 상태 코드에 따라서 예외로 매핑할 수 있게 해줌
    - Request.Options : 요청의 readTimeout, connectionTimeout 시간을 설정할 수 있음
    - RequestInterceptor : RequestInterceptor를 등록해서 사용

```java
feign:
  client:
    config:
      feignName:
        connectTimeout: 5000
        readTimeout: 5000
        loggerLevel: full
```


## 3.  @SpringQueryMap

- Spring Cloud OpenFeign 라이브러리에서 제공하는 어노테이션 중 하나
- Feign 클라이언트에서 요청을 보낼 때, Query Parameter를 맵 형태로 전달하기 위해 사용
- @RequestParam과 유사한 역할 수행하지만, **여러 개의 파라미터가 아닌 단일 맵 형태로 전달**
  할 수 있다는 점이 다르다.
- ****@RequestParam 사용 예시****

```kotlin
		@GetMapping("/request_param")
    fun requestParam(
        @RequestParam("id") id: Int,
        @RequestParam("name") name: String,
    ) : String {
        return "${id} ${name}"
    }
```

- ****@SpringQueryMap 사용 예시****

```kotlin
		@GetMapping("/spring_query_map")
    fun springQueryMap(
        @SpringQueryMap queryParams: MyQueryParam,
    ) : String {
        return "${queryParams.id} ${queryParams.name}"
    }
    
    data class MyQueryParam(
        val id: Int,
        val name: String,
    )
```

- 테스트코드

```kotlin
@ExtendWith(SpringExtension::class)
@WebMvcTest(SpringQueryMapController::class)
@AutoConfigureMockMvc
class SpringQueryMapControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    companion object {
        const val id = "1"
        const val name = "test"

        val queryParams = LinkedMultiValueMap(mapOf(
            "id" to listOf(id),
            "name" to listOf(name)
        ))

        const val PREFIX = "/spring_query_map"
    }

    @Test
    fun requestParamTest() {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("$PREFIX/request_param")
            .queryParams(queryParams)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        assertEquals("${id} ${name}", result.response.contentAsString)
    }

    @Test
    fun springQueryMapTest() {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("$PREFIX/spring_query_map")
            .queryParams(queryParams)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        assertEquals("${id} ${name}", result.response.contentAsString)
    }
}
```

## 기타

- feign은 어떤 값을 넣었는데 아무런 어노테이션도 없는 경우 Body 라고 인식한다.
- 꼭 명시적으로 `@PathVariable`인지, `@RequestParam`를 통해서 `Query String`
  인지 명시해주지 않으면 `Method has too many Body parameters`
 라는 메시지를 아주 많이 보게된다.

## 참고

- [https://wedul.site/160](https://wedul.site/160)
- [https://marrrang.tistory.com/81?category=880967](https://marrrang.tistory.com/81?category=880967)
- [https://dlee0129.tistory.com/292](https://dlee0129.tistory.com/292)