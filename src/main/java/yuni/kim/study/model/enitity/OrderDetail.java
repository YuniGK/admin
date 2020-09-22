package yuni.kim.study.model.enitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderGroup", "item"})
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    //숫자를 정밀하게 저장하고 표현할 수 있는 유일한 방법, 돈과 소수점을 다룬다면 BigDecimal은 선택이 아니라 필수
    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private Long orderGroupId;

    //OrderDetail N : Item 1
    @ManyToOne
    private Item item;

    //OrderDetail N : OrderGrop 1
    @ManyToOne
    private OrderGroup orderGroup;

}
