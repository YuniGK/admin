package yuni.kim.study.controller;

import org.springframework.web.bind.annotation.*;
import yuni.kim.study.model.SearchParam;

@RestController
@RequestMapping("/api")
public class PostController {

    /* post 방식
    * Html <form>
    * ajax 검색
    * http post body → data를 넣어서 보낼 시 사용된다.
    *
    * post는 json, xml, multipart-form / text를 받을 수 있다. */

    /* @RequestMapping(method = RequestMethod.POST, path = "postMethod") 아래의 내용과 동일하다.
    @PostMapping(value = "/postMethod", produces = {"application-json"})

    produces - 어떤 형식의 데이터를 받는지 알려준다. 기본 json형식을 받는다. 생략 가능하다. */
    @PostMapping(value = "/postMethod")
    /* @RequestBody 어노테이션과 @ResponseBody 각각 HTTP 요청 몸체를 자바 객체로 변환,
    자바 객체를 HTTP 응답 몸체로 변환하는 데 사용

    @RequestBody HTTP 요청 몸체를 자바 객체로 전달
    @ResponseBody 객체를 HTTP 응답 몸체로 전송 */
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

    /* Rest API - 주소를 할당해서 사용하지 않는다.
    * PUT / PATCH - (POST 처럼)body에 데이터가 들어 있으며, 주로 업데이트시에 사용
    * DELETE - (GET처럼)주소에 파라미터가 들어가며, 삭제시에 사용
    *
    * get ▷ 동작 > 조회시 사용 SELECT * READ │ URL형식 > /user/{id}
    * post ▷ 동작 > 생성시 사용 CREATE │ URL형식 > /user
    * put/patch ▷ 동작 > 수정시 사용 UPDATE * CREATE │ URL형식 > /user
    * delete ▷ 동작 > 삭제시 사용 DELETE │ URL형식 > /user/{1} → 1번 유저 삭제 */

    @PutMapping
    public void put(){}
    @PatchMapping
    public void patch(){}
    @DeleteMapping
    public void delete(){}
}
