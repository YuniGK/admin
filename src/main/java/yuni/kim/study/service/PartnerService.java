package yuni.kim.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuni.kim.study.model.enitity.Partner;
import yuni.kim.study.model.network.Header;
import yuni.kim.study.model.network.request.PartnerRequert;
import yuni.kim.study.model.network.response.PartnerResponse;
import yuni.kim.study.repository.CategoryRepository;

@Service
public class PartnerService extends BaseService<PartnerRequert, PartnerResponse, Partner> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Header<PartnerResponse> create(Header<PartnerRequert> request) {
        return null;
    }

    @Override
    public Header<PartnerResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(p -> response(p))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<PartnerResponse> update(Header<PartnerRequert> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<PartnerResponse> response(Partner partner){
        PartnerResponse body = PartnerResponse.builder()
                                .id(partner.getId())
                                .name(partner.getName())
                                .status(partner.getStatus())
                                .address(partner.getAddress())
                                .callCenter(partner.getCallCenter())
                                .partnerNumber(partner.getPartnerNumber())
                                .businessNumber(partner.getBusinessNumber())
                                .ceoName(partner.getCeoName())
                                .registeredAt(partner.getRegisteredAt())
                                .unregisteredAt(partner.getUnregisteredAt())
                                .categoryId(partner.getCategory().getId())
                            .build();

        return Header.OK(body);
    }

}
