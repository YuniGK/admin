package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();

        user.setAccount("user02");
        user.setPassword("test02");
        user.setStatus("registered");
        user.setEmail("test02@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setRegisteredAt(LocalDateTime.now());

        User newUser = userRepository.save(user);

        assertNotNull(newUser);

        assertEquals(newUser.getId(), user.getId());

    }

    @Test
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1234-5678");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("------- 주문묶음 -----");
            System.out.println("수령인 " + orderGroup.getRevName());

            System.out.println("------- 주문상세 -----");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("주문상태 " + orderDetail.getStatus());

                System.out.println("주문상품 " + orderDetail.getItem().getName());
            });
        });

        assertNotNull(user);
    }

}