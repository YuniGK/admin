package yuni.kim.study.model.enitity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "orderDetailList"})
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    //주문형태 일괄 / 개별
    private String orderType;

    private String revAddress;

    private String revName;

    //결제 수단 카드 / 현금
    private String paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    @CreatedDate //엔티티 생성 시간 자동 주입
    private LocalDateTime createdAt;

    @CreatedBy //엔티티 생성 사용자 정보를 자동 주입
    private String createdBy;

    @LastModifiedDate //엔티티 수정 시간 자동 주입
    private LocalDateTime updatedAt;

    @LastModifiedBy //엔티티 수정한 사용자 정보를 자동 주입
    private String updatedBy;

    //OrderGroup N : User 1
    @ManyToOne
    public User user;

    //OrderGrop 1 : OrderDetail N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;

}
