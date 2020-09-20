package yuni.kim.study.controller;

import org.springframework.web.bind.annotation.*;
import yuni.kim.study.model.SearchParam;

@RestController
@RequestMapping("/api") //http://localhost:8080/api
public class GetController {

    //@RequestBody와 같이 데이터를 출력한다.
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //http://localhost:8080/api/getMethod
    public String getRequest(){
        return "Get Method";
    }

    @GetMapping("/getParamet")
    /*
    @RequestParam 파라미터 값을 받는다.
    http://localhost:8080/api/getParamet?id=test&pwd=1234
    */

    /* public String getParameter(@RequestParam String id, @RequestParam String pwd){
    * getParameter 메서드 안에 지역변수로 password를 사용할 경우, 파라미터로 받는 내용과 겹치므로,
    * pwd로 이름을 변경하고, 파라미터의 이름은 password라고 알려준다.
    *
    * http://localhost:8080/api/getParamet?id=test&password=1234*/
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        System.out.printf("id : %s / pwd : %s", id, pwd);

        return id+pwd;
    }

    //http://localhost:8080/api/getMultiParameter?account=test&email=test@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.printf("account : %s / email : %s / page : %d ", searchParam.getAccount(), searchParam.getEmail(), searchParam.getPage());

        //자동적으로 json타입으로 결과값을 반환한다. {"account":"test","email":"test@gmail.com","page":10}
        return searchParam;
    }

}
