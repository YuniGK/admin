package yuni.kim.study.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //http://localhost:8080/api
public class GetController {

    //@RequestBody와 같이 데이터를 출력한다.
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //http://localhost:8080/api/getMethod
    public String getRequest(){
        return "Get Method";
    }

    @GetMapping("/getParamet")
    public String getParameter(){
        return null;
    }

}
