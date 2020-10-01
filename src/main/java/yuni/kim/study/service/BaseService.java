package yuni.kim.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import yuni.kim.study.controller.ifs.CrudInterface;

@Component
public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res> {

    //기본 설정은 아니다.
    @Autowired(required = false)
    protected JpaRepository<Entity, Long> baseRepository;
            //JpaRepository<Item, Long>

}
