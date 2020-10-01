package yuni.kim.study.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuni.kim.study.controller.CrudController;
import yuni.kim.study.model.enitity.Partner;
import yuni.kim.study.model.network.request.PartnerRequert;
import yuni.kim.study.model.network.response.PartnerResponse;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiConterller extends CrudController<PartnerRequert, PartnerResponse, Partner> {

}
