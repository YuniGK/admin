package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();

        user.setAccount("user01");
        user.setPassword("test01");
        user.setStatus("registered");
        user.setEmail("test01@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("AdminServer");

        User newUser = userRepository.save(user);

        assertNotNull(newUser);

        assertEquals(newUser.getId(), user.getId());

    }

    @Test
    public void read(){
        User newUser = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1234-5678");

        assertNotNull(newUser);
    }

}