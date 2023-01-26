package jpabook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

        Long id = 1111L;
        Member member = new Member();
        //member.setId(id);
        member.setUsername("ssookie");
        member.setAge(2);

        //등록
        em.persist(member);

        member.getId();

        //수정
        member.setAge(20);

        //한 건 조회
        Member findMember = em.find(Member.class, member.getId());
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge() );
        System.out.println("findId >>>>>>>> =" + member.getId());

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());

        //삭제
        //em.remove(member);
    }
}