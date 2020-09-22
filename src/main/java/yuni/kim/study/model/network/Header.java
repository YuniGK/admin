package yuni.kim.study.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T>{

    //동일한 데이터가 들어간다.

    //api 통신시간
    /* @JsonProperty("transction_time") 지정해서 snake_case로 지정이 가능하다.
    *
    * application.properties에서 별도로 지정하면 위와 같은 설정을 하지 않아도
    * 자동으로 snake_case로 지정된다. */
    //private String transctionTime;
    private LocalDateTime transctionTime;

    //api 응답코드
    private String resultCode;

    //api 부가설명
    private String description;
    
    //데이터 body = 변경되는 내용
    private T data;

    //OK
    public static <T> Header<T> OK(){
        return (Header<T>)Header.builder()
                .transctionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //DATA OK
    public static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder()
                .transctionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    //ERROR
    public static <T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder()
                .transctionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }

}

