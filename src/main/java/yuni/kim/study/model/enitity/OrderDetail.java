package yuni.kim.study.model.enitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"user", "item"}) //toString()에서 user, item을 제외시킨다.
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    /* @ManyToOne = n : 1 = 다대 : 1
    * private Long userId; 다대 : 1 관계를 설정할 경우
    * 연결된 테이블의 이름으로 작성해준다.
    * private User user; → user_id를 알아서 연결시켜준다.
    *
    * user객체에서 설정을 별도로 해주어야 한다. */
    @ManyToOne
    private User user;

    @ManyToOne
    private Item item;

}
