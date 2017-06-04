package tech.codemaster.bat50question.lombok;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tom Deng
 * @date 2017-03-30
 **/
@Slf4j
public class PersonLombokTest {
    public static void main(String... args) {
        Person person = Person.builder()
            .name("dengzhwei")
            .age(35)
            .city("beijing")
            .sex("男").build();
        log.info("name:{},age:{},city:{},sex:{}", person.getName(), person.getAge(), person.getCity(), person.getSex());
    }
}
