package yuni.kim.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yuni.kim.study.model.enitity.User;

@Repository
/* Entity의 기본적인 CRUD가 가능하도록 JpaRepository 인터페이스를 사용한다.
* <어떤 타입 클래스를 사용할 것인지, 기본키의 타입형> */
public interface UserRepository extends JpaRepository<User, Long> {

        //가장 최근에 저장된 값이 리턴된다.
                                //아이디 역순으로 정렬된다.
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

}
