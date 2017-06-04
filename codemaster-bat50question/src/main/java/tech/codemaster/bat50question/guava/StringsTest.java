package tech.codemaster.bat50question.guava;

import java.security.MessageDigest;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;

/**
 * @author Tom Deng
 * @date 2017-03-30
 **/
public class StringsTest {
    public static void main(String... args) {
        Optional<Integer> possible = Optional.of(2);
        System.out.println(possible.orNull());

        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        list.stream().forEach(System.out::println);

        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
    }
}
