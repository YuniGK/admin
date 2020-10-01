package yuni.kim.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {

    CACHE(0, "현금"),
    CARD(1, "카드"),
    PAY(2, "페이");

    private Integer id;
    private String title;

}
