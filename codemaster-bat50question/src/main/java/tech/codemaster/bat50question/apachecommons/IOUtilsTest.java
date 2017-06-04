package tech.codemaster.bat50question.apachecommons;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * @author Tom Deng
 * @date 2017-03-30
 **/
public class IOUtilsTest {
    public static void main(String... args) {
        String file = "/Users/tomdeng/Downloads/test.txt";
        try {
            List<String> lines = IOUtils.readLines(new FileInputStream(file), StandardCharsets.UTF_8);
            lines.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
