package yuni.kim.study.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuni.kim.study.controller.CrudController;
import yuni.kim.study.model.enitity.User;
import yuni.kim.study.model.network.request.UserApiRequest;
import yuni.kim.study.model.network.response.UserApiResponse;

@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

}

/*
@Slf4j//log를 남긴다.
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")
    * @ResponseBody & @RequestBody
    * @RequestBody - HTTP 요청 Body를 자바 객체로 전달
    * @ResponseBody - 선택한 형식으로 결과값을 변환하여 반환
    * 자바 객체를 HTTP 응답 body로 전송
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("create = {}", request); //request.toString()가 찍힌다.

        return userApiLogicService.create(request);
    }
    C

    @Override
    @GetMapping("{id}")
    * @GetMapping("{ids}")
    * public Header read(@PathVariable(name = "ids") Long id)
    *
    * {} 변수의 이름이 파라미터의 값과 다를 경우, PathVariable를 통해
    * 이름을 알려줘야 한다.
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        log.info("read id = {}",id);

        return userApiLogicService.read(id);
    }
    R

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        log.info("update = {}",request);

        return userApiLogicService.update(request);
    }
    U

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("delete = {}",id);

        return userApiLogicService.delete(id);
    }
    D

}
*/