package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.OrderGroup;
import yuni.kim.study.model.enumclass.OrderStatus;
import yuni.kim.study.model.enumclass.OrderType;
import yuni.kim.study.model.enumclass.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderGroupRepositoryTest extends StudyApplicationTests {

    @Autowired
    OrderGroupRepository orderGroupRepository;

    @Test
    public void create() {
        OrderGroup orderGroup = new OrderGroup();

        orderGroup.setStatus(OrderStatus.REGISTERED);
        orderGroup.setOrderType(OrderType.ALL);
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setRevName("홍길동");
        orderGroup.setPaymentType(PaymentType.CARD);
        orderGroup.setTotalPrice(BigDecimal.valueOf(100000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now());

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

        assertNotNull(newOrderGroup);

    }

}