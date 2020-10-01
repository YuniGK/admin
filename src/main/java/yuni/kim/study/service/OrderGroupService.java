package yuni.kim.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuni.kim.study.model.enitity.OrderGroup;
import yuni.kim.study.model.network.Header;
import yuni.kim.study.model.network.request.OrderGroupRequert;
import yuni.kim.study.model.network.response.OrderGroupResponse;
import yuni.kim.study.repository.UserRepository;

import java.util.Optional;

@Service
public class OrderGroupService extends BaseService<OrderGroupRequert, OrderGroupResponse, OrderGroup> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupResponse> create(Header<OrderGroupRequert> request) {
        OrderGroupRequert body = request.getData();

        OrderGroup orderGroup = OrderGroup
                                    .builder()
                                        .status(body.getStatus())
                                        .orderType(body.getOrderType())
                                        .revAddress(body.getRevAddress())
                                        .revName(body.getRevName())
                                        .paymentType(body.getPaymentType())
                                        .totalPrice(body.getTotalPrice())
                                        .totalQuantity(body.getTotalQuantity())
                                        .orderAt(body.getOrderAt())
                                        .user(userRepository.getOne(body.getUserId()))
                                    .build();

        OrderGroup newOrderGroup = baseRepository.save(orderGroup);

        return response(newOrderGroup);
    }

    @Override
    public Header<OrderGroupResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(orderGroup -> response(orderGroup))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<OrderGroupResponse> update(Header<OrderGroupRequert> request) {
        OrderGroupRequert body = request.getData();

        Optional<OrderGroup> optional = baseRepository.findById(body.getId());

        return optional.map(orderGroup -> {
            orderGroup.setStatus(body.getStatus())
                    .setOrderType(body.getOrderType())
                    .setRevAddress(body.getRevAddress())
                    .setRevName(body.getRevName())
                    .setPaymentType(body.getPaymentType())
                    .setTotalPrice(body.getTotalPrice())
                    .setTotalQuantity(body.getTotalQuantity())
                    .setArrivalDate(body.getArrivalDate())
                    .setOrderAt(body.getOrderAt());

            return orderGroup;
            })
                .map(o -> baseRepository.save(o))
                .map(o -> response(o))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(orderGroup -> {
                    baseRepository.delete(orderGroup);

                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<OrderGroupResponse> response(OrderGroup orderGroup){
        OrderGroupResponse body = OrderGroupResponse.builder()
                                    .id(orderGroup.getId())
                                    .status(orderGroup.getStatus())
                                    .orderType(orderGroup.getOrderType())
                                    .revAddress(orderGroup.getRevAddress())
                                    .revName(orderGroup.getRevName())
                                    .paymentType(orderGroup.getPaymentType())
                                    .totalPrice(orderGroup.getTotalPrice())
                                    .totalQuantity(orderGroup.getTotalQuantity())
                                    .orderAt(orderGroup.getOrderAt())
                                    .arrivalDate(orderGroup.getArrivalDate())
                                    .userId(orderGroup.getUser().getId())
                                .build();

        return Header.OK(body);
    }

}
