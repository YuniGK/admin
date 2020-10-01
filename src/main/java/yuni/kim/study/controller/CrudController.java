package yuni.kim.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import yuni.kim.study.controller.ifs.CrudInterface;
import yuni.kim.study.model.network.Header;
import yuni.kim.study.service.BaseService;

@Slf4j
@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

    //상속받은 곳에서만 접근이 가능하다.
    //protected CrudInterface<Req, Res> baseService;
    @Autowired(required = false)
    protected BaseService<Req, Res, Entity> baseService;

    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> request) {
        log.info("create {}", request);

        return baseService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/item/{id}
    public Header<Res> read(@PathVariable Long id) {
        log.info("read {}", id);

        return baseService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<Res> update(@RequestBody Header<Req> request) {
        log.info("update {}", request);

        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{id}") // /api/item/{id}
    public Header delete(@PathVariable Long id) {
        log.info("delete {}", id);

        return baseService.delete(id);
    }

}
