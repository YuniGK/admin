package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.OrderDetail;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("waiting");
        //도착일은 현재로 부터 이틀 뒤
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        //BigDecimal.valueOf () 메서드는 비슷한 형식 매개 변수를 사용하는 생성자보다 우선적으로 제공
        orderDetail.setTotalPrice(BigDecimal.valueOf(100000));

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        assertNotNull(newOrderDetail);
    }

}