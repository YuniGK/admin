package yuni.kim.study.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
/* Spring(IOC) Container에 Bean을 등록하도록 하는 메타데이터를 기입하는 어노테이션으로,
* 개발자가 직접 작성한 Class를 Bean으로 등록한다. */
            //로그인한 사용자 감시
public class LoginUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        /* @CreatedBy / @LastModifiedBy - 엔티티 생성/수정 사용자 정보를 자동 주입된다.
        *
        * Optional.of("AdminServer") 내용을 자동으로 주입된다. */
        return Optional.of("AdminServer");
    }

}
