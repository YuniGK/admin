package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.User;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();

        user.setAccount("TestUser03");
        user.setEmail("testUser03@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser03");

        User newUser = userRepository.save(user);
    }



    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            System.out.println("user "+ selectUser);
        });
    }

    @Test
    public void update(){
        /* findById()한 아아디를 찾은 후 아래의 내용이 null이 아니면 변경한다.
        *
        * update / delete 모두 아래의 내용은 동일하게 적용된다.
        * 하지만, user.ifPresent()에서 아이디를 지정할 경우 findById()로 찾은 아이디가 아닌,
        * user.ifPresent()에서 지정한 아이디에 대한 내용이 변경된다. */
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            //account 변경 및 업데이트 날짜 생성
            selectUser.setAccount("A");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatdBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete(){

        Optional<User> user = userRepository.findById(2L);

        //2L 아이디를 가진 user가 있으면 true가 된다.
        assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);
        /*
        if (deleteUser.isPresent()){
            System.out.println("존재 "+deleteUser.get());
        }else{
            System.out.println("삭제");
        }
        */

        //2L 아이디를 가진 user를 삭제했기에 값이 fale가 된다.
        assertFalse(deleteUser.isPresent());

    }

}