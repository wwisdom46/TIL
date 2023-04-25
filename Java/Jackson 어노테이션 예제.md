### **1. @*JsonIgnoreProperties***

- **클래스 레벨** 어노테이션으로, Jackson이 무시할 property 리스트를 지정할 수 있다.
- **ignoreUnkown=true** 속성은 JSON 입력 값에 대하여 Mapping 시 클래스에 선언되지 않은 property를 무시한다.

> UnrecognizedPropertyException
>

```java
@JsonIgnoreProperties({ "id" })
public class BeanWithIgnore {
    public int id;
    public String name;
}
```

```java
/** @JsonIgnoreProperties 적용 전 */
{
  "id" : 1,
  "name" : "My Bean"
}

/** @JsonIgnoreProperties 적용 후 */
{
  "name" : "My Bean"
}
```

### **2. @*JsonIgnore***

- **필드 레벨**에 적용되어 해당 필드를 Jackson이 무시할 수 있도록 한다.
- @JsonIgnoreProperties가 클래스 레벨에서 무시할 필드들을 지정해준다면, @JsonIgnore는 필드 하나하나에 붙여 무시하도록 지정하는 방식이다.

```java
public class BeanWithIgnore {
    @JsonIgnore
    public int id;

    public String name;
}
```

```java
/** @JsonIgnore 적용 전 */
{
  "id" : 1,
  "name" : "My Bean"
}

/** @JsonIgnore 적용 후 */
{
  "name" : "My Bean"
}
```

### **3. @*JsonIgnoreType***

- 선언된 어노테이션 하위 모든 Properties를 무시하도록 한다. 아래의 예시는 정적 멤버 클래스의 필드를 모두 무시한다.

```java
public class User {
    public int id;
    public Name name;

    @JsonIgnoreType
    public static class Name {
        public String firstName;
        public String lastName;
    }
}
```

```java
@Test
public void testJsonIgnoreType() throws JsonProcessingException {
	User.Name name = new User.Name("Changwoo", "Son");
	User user = new User(1, name);

	System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter()
        .writeValueAsString(user));
}
```

```java
/** @JsonIgnoreType 적용 전 */
{
  "id" : 1,
  "name" : {
    "firstName" : "Changwoo",
    "lastName" : "Son"
  }
}

/** @JsonIgnoreType 적용 후 */
{
  "id" : 1
}
```

### **4. @*JsonInclude***

- @JsonInclude는 특정 조건에 해당하는 property를 제외하고 se/deserialize 할 수 있도록 도와준다.
- 아래의 예시는 **NON_NULL** 조건으로 null인 property는 대상에서 제외하게 된다.

```java
@JsonInclude(Include.NON_NULL)
public class MyBean {
    public int id;
    public String name;
}
```

```java
@Test
public void testJsonInclude() throws JsonProcessingException {
	MyBean myBean = new MyBean(1, null);

	System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(myBean));
}
```

```java
/** @JsonInclude 적용 전 */
{
  "id" : 1,
  "name" : null
}

/** @JsonInclude 적용 후 */
{
  "id" : 1
}
```

### 5. **@*JsonAutoDetect***

- @JsonAutoDetect 어노테이션은 Mapping 규칙을 유연하게 바꿀 수 있도록 도와준다.
- 멤버 변수뿐만 아니라 getter, setter의 Mapping 규칙 또한 지정할 수 있다.
- 아래의 예시는 **fieldVisibility = Visibility.ANY**를 통해 필드에 대한 Mapping 규칙을 private부터 public까지로 지정한다.
- 이 어노테이션을 통해 private 변수에 대해 serialize와 deserialize 과정에서 일어나는 데이터 접근 에러를 막을 수 있다.

```java
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class PrivateBean {
	private int id;
	private String name;
}
```

```java
@Test
public void testJsonInclude() throws JsonProcessingException {
	MyBean myBean = new MyBean(1, null);

	System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(myBean));
}
```

```java
@Test
public void testJsonAutoDetect() throws IOException {
	String json = "{\"id\":1, \"name\":\"changwoo\"}";

// deserialization
	PrivateBean privateBean = new ObjectMapper()
		.readerFor(PrivateBean.class)
		.readValue(json);

// Serialization
	System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(privateBean));
}
```

---

## 참고

[https://www.baeldung.com/jackson-annotations](https://www.baeldung.com/jackson-annotations)