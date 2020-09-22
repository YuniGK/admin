package yuni.kim.study.model.enitity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/* DB 테이블명과 클래스명을 일치시킨다.
 * 이름이 일치하지 않을 경우 설정해준다. @Table(name = "user")*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderGroupList"})
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
//@Table(name = "user")
public class User {
    //@Id - 식별자 / @GeneratedValue - 기본키 / GenerationType.IDENTITY - 기본키 생성은 db에게 위임한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @Column(name = "account") db의 컬럼명과 필드명이 다를 경우 설정해준다.
    private String account;

    private String password;

    private String status;

    private String email;

    // phone_number 자동으로 phoneNumber인식한다.
    private String phoneNumber;

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

    //User 1 : OrderGroup N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;

}
