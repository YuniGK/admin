package yuni.kim.study.model.enitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/* DB 테이블명과 클래스명을 일치시킨다.
 * 이름이 일치하지 않을 경우 설정해준다. @Table(name = "user")*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "user")
public class User {
    //@Id - 식별자 / @GeneratedValue - 기본키 / GenerationType.IDENTITY - 기본키 생성은 db에게 위임한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @Column(name = "account") db의 컬럼명과 필드명이 다를 경우 설정해준다.
    private String account;

    private String email;

    // phone_number 자동으로 phoneNumber인식한다.
    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatdBy;

    /* 1:N
    * mappedBy = "user" → OrderDetail에 설정해놓은 user와 동일한 이름이다.
    *
    * LAZY = 지연로딩, 연관된 테이블을 별도로 조회하지 않는다.
    * select * from item where id = ?
    *
    * EAGER = 즉시로딩, 1:1 권장한다.
    * ... join item ... 연관 테이블을 모두 조회한다. */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailList;
}
