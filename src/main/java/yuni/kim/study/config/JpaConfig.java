package yuni.kim.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //설정파일이라는 것을 알려준다.
@EnableJpaAuditing //vo = enitity 생성을 auddit(감시)하는 목적
public class JpaConfig {

}
