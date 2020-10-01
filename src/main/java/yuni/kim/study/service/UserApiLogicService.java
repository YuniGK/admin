package yuni.kim.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuni.kim.study.controller.ifs.CrudInterface;
import yuni.kim.study.model.enitity.User;
import yuni.kim.study.model.enumclass.UserStatus;
import yuni.kim.study.model.network.Header;
import yuni.kim.study.model.network.request.UserApiRequest;
import yuni.kim.study.model.network.response.UserApiResponse;
import yuni.kim.study.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    /* 1. request data
     * 2. user 생성
     * 3. 생성된 데이터 → UserApiResponse return */
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        //1. request data
        UserApiRequest userApiRequest = request.getData();

        /* @Builder를 이용한 내용 추가
        *
        * User user = New User();
        * user.setAccount();
        *
        * User newUser = userRepository.save(user);
        * ... 한 것과 아래의 내용이 동일하다. */
        //2. user 생성
        User user = User.builder()
                    .account(userApiRequest.getAccount())
                    .password(userApiRequest.getPassword()) //암호화 / 길이 변경하기
                    .status(UserStatus.REGISTERED)
                    .phoneNumber(userApiRequest.getPhoneNumber())
                    .email(userApiRequest.getEmail())
                    .registeredAt(LocalDateTime.now())
                    .build();

        User newUser = userRepository.save(user);

        /* 3. 생성된 데이터 →UserApiResponse return - 해당 부분은
        다른 부분에서도 사용이 가능한 부분으로 메서드화 한다. */
        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        //repository를 통해 id를 찾는다.
        Optional<User> optional = userRepository.findById(id);

        //userApiResponse
        return optional
            /* mapper 함수를 통해 입력값을 다른 값으로 변환하는 메서드
             * user가 있을 경우 response(user) 만들고 없을 경우 에러에 값을 전달한다.
             *
             * :: 메서드의 파라미터로 핵심 행위를 다른 선언 없이 바로 파라미터로 전달 */
            .map(user -> response(user))
            .map(Header::OK)
            .orElseGet(() -> Header.ERROR("데이터 없음")
        );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> requert) {
        //data를 가지고 온다.
        UserApiRequest userApiRequest = requert.getData();

        //id를 통해 user 데이터를 찾는다.
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            //data를 통해서 update문을 생성한다.
            user.setAccount(userApiRequest.getAccount())
                .setPassword(userApiRequest.getPassword())
                .setStatus(userApiRequest.getStatus())
                .setPhoneNumber(userApiRequest.getPhoneNumber())
                .setEmail(userApiRequest.getEmail())
                .setRegisteredAt(userApiRequest.getRegisteredAt())
                .setUnregisteredAt(userApiRequest.getUnregisteredAt());

            return user;
        })
            .map(user -> userRepository.save(user)) //update가 실행되어 새로운 newUser이 생성된다.
            .map(updateUser -> response(updateUser))//userApiResponse가 생성된다.
            .map(Header::OK)
            .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return optional
            .map(user -> {
                userRepository.delete(user);

                return Header.OK();
            })
            .orElseGet(() -> Header.ERROR("데이터 없음"));
    }
    
    //3. 생성된 데이터 → UserApiResponse return
    private UserApiResponse response(User user){
        //user → userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        //Header + data return
        return userApiResponse;

    }

}
