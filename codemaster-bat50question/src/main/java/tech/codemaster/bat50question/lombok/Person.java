package tech.codemaster.bat50question.lombok;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Tom Deng
 * @date 2017-03-30
 **/
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {
    private String name;
    private String sex;
    private Integer age;
    private String city;
}
