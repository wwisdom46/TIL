---
# Spring WebFlux 란?

- Spring 5 에서 새롭게 추가된 모듈
- Client, Server에서 reactive 스타일의 어플리케이션 개발을 도와주는 모듈
- 논블로킹(Non-Blocking) 에 reactive stream 지원

<aside>
💡 블로킹 Vs. 논블로킹

- 블로킹 : 함수 A가 함수 B를 호출했을 때 함수 B를 처리할 동안 함수 B가 제어권을 가지고 있어 작업이 모두 끝날 때 까지 함수 A가 대기상태가 된다. 쉽게 말해 처리해야 할 작업이 있으면 그것을 처리할동안 가만히 대기를 하고있는 것을 말한다.

- 논블로킹 : 함수 A가 함수 B를 호출할 때 함수 A는 제어권을 넘기지 않고 자신의 할일을 할 수 있다.
  처리해야할 작업이 있다면 일을 시켜놓고 자신은 자신의 일을 하는 것이다.

</aside>

### WebFlux가 생긴 이유

> 1) 적은양의 스레드와 최소한의 하드웨어 자원으로 동시성을 핸들링하기 위해
> 2) 함수형 프로그래밍 때문. Java5에서 Rest controllers나 unit test가 만들어지고,
   Java8에서는 함수형 API를 위한 Lambda 표현식이 추가됐다.
   이는 논블로킹 어플리케이션 API의 토대가 됐다.

### WebFlux가 적은 리소스로 많은 트래픽을 감당할 수 있는 이유

> 1) I/O를 Non-Blocking을 이용하여 잘 사용하기 때문
> 2) Request를 Event-Driven을 통해서 효율적으로 처리하기 때문


### WebFlux 사용이 적절한 프로젝트

> 1) 서비스간 호출이 많은 마이크로서비스 아키텍처에 적합
> 2) 비동기 - 논블록킹 리액티브 개발에 사용
> 3) 효율적으로 동작하는 고성능 웹어플리케이션 개발

### 장점

> 1) 고성능
> 2) spring 과 완벽한 통합
> 3) netty 지원
> 4) 비동기 non-blocking 메세지 처리


### 단점

> 1) 오류처리가 다소 복잡
> 2) Back Pressure 기능은 없음


## Spring MVC Vs. WebFlux

<img src="https://docs.spring.io/spring-framework/docs/current/reference/html/images/spring-mvc-and-webflux-venn.png">

## **참고**

- [https://heeyeah.github.io/spring/2020-02-29-web-flux/](https://heeyeah.github.io/spring/2020-02-29-web-flux/)
- [https://godekdls.github.io/Reactive%20Spring/springwebflux/](https://devuna.tistory.com/108)
- [https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-framework-choice](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-framework-choice)
- [https://camelsource.tistory.com/73](https://camelsource.tistory.com/73)