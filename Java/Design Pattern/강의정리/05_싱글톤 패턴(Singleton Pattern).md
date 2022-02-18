# 5_싱글톤 패턴(Singleton Pattern)

> 정의
>
- 생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고,  최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴한다. 이와 같은 디자인 유형을 싱글턴 패턴이라고 한다.
- 인스턴스가 남용되지 않고 오직 1개만 생성되어야 하는 경우에 사용하는 방식

> 사용 및 예제
>
- 하나의 스피커를 여러명의 사원이 공유하여 사용되어야 할 때
- 기본생성자를 `private`를 사용하여 생성을 불가능하게 하고 getInstance를 통해서만 생성이 가능

```java
public class SystemSpeaker {
    private static SystemSpeaker instance;
    private int volume;

    private SystemSpeaker() {
        volume = 5;
    }

    public static SystemSpeaker getInstance() {
        if (instance == null) {
            instance = new SystemSpeaker();
            System.out.println("새로 생성");
        } else {
            System.out.println("이미 생성");
        }
        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
```

> 문제점
>
- 싱글톤은 프로그램 전체에서 하나의 객체만을 공통으로 사용하고 있기 때문에 각 객체간의 결합도가 높아지고 변경에 유연하게 대처할 수 없다.
- 또한 멀티쓰레드 환경에서 쓰레드가 공유되고 있을 때 아래 블럭에서 조건문이 동시에 두 번 돌 수 있기 때문에 하나의 인스턴스가 아닌 여러개의 인스턴스가 발생할 위험이 있다.

```java
public static SystemSpeaker getInstance() {
        if (instance == null) {
            instance = new SystemSpeaker();
        } 
        return instance;
    }

```

> 문제점 해결방안
>
- 멀티쓰레드 환경에서 싱글톤의 문제를 해결할 수 있는 방안
    - 정적 변수에 인스턴스를 만들어 바로 초기화 하는 방법

    ```java
    public class SystemSpeaker {
        private static SystemSpeaker systemSpeaker = new SystemSpeaker();
        private int volume;
    
        private SystemSpeaker() {
            volume = 5;
        }
    
        public static SystemSpeaker getInstance() {
            return systemSpeaker;
        }
    }
    ```


> 참고
>

[https://youtu.be/5jgpu9-ywtY](https://youtu.be/5jgpu9-ywtY)

[https://velog.io/@kyle/자바-싱글톤-패턴-Singleton-Pattern](https://velog.io/@kyle/%EC%9E%90%EB%B0%94-%EC%8B%B1%EA%B8%80%ED%86%A4-%ED%8C%A8%ED%84%B4-Singleton-Pattern)

[https://blog.naver.com/inbv4311/222339311680](https://blog.naver.com/inbv4311/222339311680)