package yuni.kim.study.controller.api;

import org.springframework.web.bind.annotation.*;
import yuni.kim.study.controller.ifs.CrudInterface;
import yuni.kim.study.model.network.Header;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {

    @Override
    @PostMapping("") // /api/user
    public Header create() {
        return null;
    }//C

    @Override
    @GetMapping("{id}")  // /api/user/{id}
    /* @GetMapping("{ids}")
    * public Header read(@PathVariable(name = "ids") Long id)
    *
    * {} 변수의 이름이 파라미터의 값과 다를 경우, PathVariable를 통해
    * 이름을 알려줘야 한다. */
    public Header read(@PathVariable Long id) {
        return null;
    }//R

    @Override
    @PutMapping("")  // /api/user
    public Header update() {
        return null;
    }//U

    @Override
    @DeleteMapping("{id}")  // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }//D

}
