package yuni.kim.study.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuni.kim.study.controller.CrudController;
import yuni.kim.study.model.enitity.OrderGroup;
import yuni.kim.study.model.network.request.OrderGroupRequert;
import yuni.kim.study.model.network.response.OrderGroupResponse;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiConterller extends CrudController<OrderGroupRequert, OrderGroupResponse, OrderGroup> {

}
