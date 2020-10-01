package yuni.kim.study.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuni.kim.study.controller.CrudController;
import yuni.kim.study.model.enitity.Item;
import yuni.kim.study.model.network.request.ItemApiRequest;
import yuni.kim.study.model.network.response.ItemApiResponse;

@RestController
@RequestMapping("/api/item")
public class ItemApiConterller extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}

/*
@RestController
@RequestMapping("/api/item")
public class ItemApiConterller extends CrudController<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    * 객체의 초기화 부분
    *객체가 생성된 후 별도의 초기화 작업을 위해 실행하는 메소드를 선언한다.
    *@PostConstruct 어노테이션을 설정해놓은 init 메소드는 WAS가 띄워질 때 실행된다.
    @PostConstruct
    public void init(){
        this.baseService = itemApiLogicService;
    }

    * 상속받아, 별도의 내용이 없을 경우 crud에 대한 내용을 작성하지 않아도 실행된다.

}
*/

/*
@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiConterller implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping("") // /api/item
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        log.info("create {}", request);
        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/item/{id}
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        log.info("read {}", id);
        return itemApiLogicService.read(id);
    }

    @Override
    @PutMapping("") // /api/item
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        log.info("update {}", request);
        return itemApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}") // /api/item/{id}
    public Header delete(@PathVariable Long id) {
        log.info("delete {}", id);
        return itemApiLogicService.delete(id);
    }
}
*/