# **Java 단일 요소의 배열 Collections.singletonList vs Arrays.asList**

메모리 절약을 위해서 요소가 없거나(empty) 하나인 경우에는 `Collections.emptyList()` 또는 `Collections.singletonList()`를 사용하자.

Arrays.asList()는 배열의 요소가 한 개여도 Collections.singletonList()보다 사이즈가 크다는 것을 추측해볼 수 있다. 각 메소드에 대해 자세히 알아보자.

## **Collections.singletonList()**

- 변경여부 : immutable (불변)
- 사이즈 : size가 1로 고정됨(지정된 단일 객체를 가르키는 주소값을 가지기 때문)
- 값 및 구조적 변경 시 UnsupportedOperationException 발생

## **Collections.emptyList()**

```java
public static final <T> List<T> emptyList() {
    return (List<T>) EMPTY_LIST;
}
```

- `Collections.emptyList()` 는 **static**으로, 이미 만들어진 객체다. 따라서 CPU와 메모리에 추가 비용이 발생하지 않는다.
- `Collections.emptyList()` 는 **final**, 불변 객체를 리턴한다. 따라서 객체를 받아 값을 변경해야 하는 등의 추가 작업이 있는 경우에는 `new ArrayList()`를 쓰는 것이 적합해보인다.

## **Arrays.asList()**

- 변경여부 : 값 변경 가능(set 메소드 허용)
- 사이즈 : 소유한 배열의 고정된 사이즈의 목록을 반환함
- 구조적 변경 시 UnsupportedOperationException 발생(ex 요소 추가, 삭제)
- ArrayList(AbstractList를 상속받은 중첩클래스)의 인스턴스를 반환함
    - 해당 클래스는 set, indexOf, forEach, replaceAll 메소드를 구현하여 제공함
    - 하지만 add 메소드 호출 시에는 AbstractList의 메소드를 호출하여 UnsupportedOperationException 반환


하드웨어가 많이 발전했기 때문에 이처럼 사소한 메모리 정도야 조금 낭비해도 된다고 생각할지도 모르겠다. 
하지만 상황에 맞게 코드를 작성하는 것은 사소한 메모리를 절약하는 그 이상의 의의가 있을 것이다.

참고
- [https://stackoverflow.com/questions/3564837/capacity-of-arraylist](https://stackoverflow.com/questions/3564837/capacity-of-arraylist)