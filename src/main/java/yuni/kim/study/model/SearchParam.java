package yuni.kim.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/* lombok을 사용하게 되면, 기본 생성자 및 getter/setter을 알아서 생성해준다.
* @NoArgsConstructor는 기본생성자, @AllArgsConstructor는 필드값을 모두 포함한 생성자를 자동 생성*/
@Data
@AllArgsConstructor
public class SearchParam {
    private int page;
    private String account, email;

    //생성자
    //getter / setter

}
