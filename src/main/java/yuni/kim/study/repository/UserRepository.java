package yuni.kim.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yuni.kim.study.model.enitity.User;

import java.util.Optional;

@Repository
/* Entity의 기본적인 CRUD가 가능하도록 JpaRepository 인터페이스를 사용한다.
* <어떤 타입 클래스를 사용할 것인지, 기본키의 타입형> */
public interface UserRepository extends JpaRepository<User, Long> {

    //select * from user where account = ?
    Optional<User> findByAccount(String account);

    //select * from user where email = ?
    Optional<User> findByEmail(String email);

    //select * from user where account = ? and email = ?
    Optional<User> findByAccountAndEmail(String account, String email);

}
