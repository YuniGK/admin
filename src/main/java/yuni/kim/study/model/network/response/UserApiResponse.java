package yuni.kim.study.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import yuni.kim.study.model.enumclass.UserStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {

    private Long id;

    private String account;

    private String password;

    private UserStatus status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

}
