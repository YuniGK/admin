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

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = {"partnerList"})
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String title;

    @CreatedDate //엔티티 생성 시간 자동 주입
    private LocalDateTime createdAt;

    @CreatedBy //엔티티 생성 사용자 정보를 자동 주입
    private String createdBy;

    @LastModifiedDate //엔티티 수정 시간 자동 주입
    private LocalDateTime updatedAt;

    @LastModifiedBy //엔티티 수정한 사용자 정보를 자동 주입
    private String updatedBy;

    // Category 1 : Partner N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Partner> partnerList;

}
