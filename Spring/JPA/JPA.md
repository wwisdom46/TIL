#JPA

---
# ORM

---

Object Relational Mapping, 객체-관계 매핑

- 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는 것을 말한다.
    - 객체 지향 프로그래밍은 클래스를 사용하고, 관계형 데이터베이스는 테이블을 사용한다.
    - 객체 모델과 관계형 모델 간에 불일치가 존재한다.
    - ORM을 통해 객체 간의 관계를 바탕으로 SQL을 자동으로 생성하여 불일치를 해결한다.
- 데이터베이스 데이터 <—매핑—> Object 필드
    - 객체를 통해 간접적으로 데이터베이스 데이터를 다룬다.
- Persistant API라고도 할 수 있다.
    - Ex) JPA, Hibernate 등

## JPA를 써야하는 이유

---

### 1) 생산성 - JPA와 CRUD

- 저장 : jap.persist(member)
- 조회 : Member member = jpa.find(memberId)
- 수정 : member.setName(”변경할 이름”)
- 삭제 : jpa.remove(member)

### 2) 유지보수 - JPA: 필드만 추가하면 됨. SQL은 JPA가 처리

### 3) JPA의 성능 최적화 기능

- 1차 캐시와 동일성 보장
- 트랜잭션을 지원하는 쓰기 지연 - INSERT, UPDATE
- 지연 로딩과 즉시 로딩 - (옵션으로 번갈아가며 사용 가능)
    - 지연 로딩 : 객체가 실제 사용될 때 로딩
    - 즉시 로딩 : JOIN SQL로 한 번에 연관된 객체까지 미리 조회

## 참고

- [https://gmlwjd9405.github.io/2019/02/01/orm.html](https://gmlwjd9405.github.io/2019/02/01/orm.html)