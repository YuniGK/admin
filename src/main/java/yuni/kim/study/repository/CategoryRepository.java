package yuni.kim.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yuni.kim.study.model.enitity.Category;

import java.util.Optional;

@Repository
/* Entity의 기본적인 CRUD가 가능하도록 JpaRepository 인터페이스를 사용한다.
* <어떤 타입 클래스를 사용할 것인지, 기본키의 타입형> */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //select * from 테이블명 where = type;
    Optional<Category> findByType(String type);

}
