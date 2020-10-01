package yuni.kim.study.model.enitity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import yuni.kim.study.model.enumclass.ItemStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderDetailList", "partner"})
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    private String name;

    private String title;

    private String content;

    private BigDecimal price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate //엔티티 생성 시간 자동 주입
    private LocalDateTime createdAt;

    @CreatedBy //엔티티 생성 사용자 정보를 자동 주입
    private String createdBy;

    @LastModifiedDate //엔티티 수정 시간 자동 주입
    private LocalDateTime updatedAt;

    @LastModifiedBy //엔티티 수정한 사용자 정보를 자동 주입
    private String updatedBy;

    // Item N : Partner 1
    @ManyToOne
    private Partner partner;

    // Item 1 : OrderDetail N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

}
