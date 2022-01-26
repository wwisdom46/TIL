## Java Bean, Spring Bean

- Java Bean
    - 특정 형태의 클래스
    - DTO, VO
- Spring Bean
    - IoC컨테이너가 관리하는 Java 객체
    - 스프링에 의해 생성되고, 라이프 사이클을 수행하고, 의존성 주입이 일어나는 객체.

  즉, 개발자가 관리하는 객체가 아닌 스프링에게 제어권을 넘긴 객체


## IoC

Spring에서 사용되는 IoC란 객체가 내부적으로 조작할 객체를 직접 생성하지 않고 외부로부터 주입받는 기법을 의미한다. 이때 객체를 외부로부터 주입해주는 작업을 DI(의존성 주입)이라고 부른다.

IoC Container는 오브젝트의 생성과 관계설정, 사용, 제거 등의 작업을 대신 해준다하여 붙여진 이름이다. 이때, IoC Container에 의해 관리되는 오브젝트들은 Bean 이라고 부른다. IoC Container는 Bean을 저장한다고 하여, BeanFactory 라고도 불린다. BeanFactory는 하나의 인터페이스이며, Application Context는 BeanFactory의 구현체를 상속받고 있는 인터페이스이다. 실제로 스프링에서 IoC Container 라고 불리는 것은 Application Context의 구현체이다.

## 빈(Bean)

Spring IoC 컨테이너가 관리하는 자바 객체를 빈(Bean)이라는 용어로 부른다.

우리가 new 연산자로 어떤 객체를 생성했을 때 그 객체는 빈이 아니다.

ApplicationContext.getBean()으로 얻어질 수 있는 객체는 빈이다.

즉 Spring에서의 빈은 ApplicationContext가 알고있는 객체, 즉 ApplicationContext가 만들어서 그 안에 담고있는 객체를 의미한다.

## 어떻게 Spring IoC 컨테이너에 빈을 등록할까?

빈을 만드는 방법은 다양하지만 기본적으로 크게 두가지 방법이 있다.

**① Component Scanning**

**② 빈 설정파일에 직접 빈을 등록**

## Component Scan

@ComponentScan 어노테이션과 @Component 어노테이션을 사용해서 빈을 등록하도록 하는 방법이다.

간단히 말하면 @ComponentScan 어노테이션은 어느 지점부터 컴포넌트를 찾으라고 알려주는 역할을 하고 @Component는 실제로 찾아서 빈으로 등록할 클래스를 의미한다.

Spring IoC 컨테이너가 IoC 컨테이너를 만들고 그 안에 빈을 등록할때 사용하는 인터페이스들을 라이프 사이클 콜백이라고 부른다.

라이프 사이클 콜백 중에는 @Component 애노테이션을 찾아서 이 애노테이션이 붙어있는 모든 클래스의 인스턴스를 생성해 빈으로 등록하는 작업을 수행하는 어노테이션 프로세서가 등록돼있다.

Spring Boot 프로젝트에서 @ComonentScan 애노테이션이 붙어있는 클래스가 이에 해당한다.

## 빈 설정파일에 직접 빈을 등록하는 방법

위와 같이 @Component 애노테이션을 사용하는 방법 말고도 빈 설정파일에 직접 빈으로 등록할 수 있다.

빈 설정파일은 XML과 자바 설정파일로 작성할 수 있는데 최근 추세는 자바 설정파일을 좀 더 많이 사용한다.

자바 설정파일은 자바 클래스를 생성해서 작성할 수 있으며 일반적으로 xxxxConfiguration와 같이 명명한다.

그리고 클래스에 @Configuration 애노테이션을 붙인다.

그 안에 @Bean 애노테이션을 사용해 직접 빈을 정의한다.

이렇게 빈을 직접 정의해서 등록하면 @Component 애노테이션을 붙이지 않아도 된다.

@Configuration 애노테이션을 보면 이 애노테이션도 @Component를 사용하기 때문에 @ComponentScan의 스캔 대상이 되고 그에 따라 빈 설정파일이 읽힐때 그 안에 정의한 빈들이 IoC 컨테이너에 등록되는 것이다.

## 참고

- [https://jjingho.tistory.com/10](https://jjingho.tistory.com/10)
- [https://atoz-develop.tistory.com/entry/Spring-스프링-빈Bean의-개념과-생성-원리](https://atoz-develop.tistory.com/entry/Spring-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B9%88Bean%EC%9D%98-%EA%B0%9C%EB%85%90%EA%B3%BC-%EC%83%9D%EC%84%B1-%EC%9B%90%EB%A6%AC)