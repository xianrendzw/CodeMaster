package tech.codemaster.bat50question.apachecommons;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author Tom Deng
 * @date 2017-03-30
 **/
public class StringUtilsTest {
    public static void main(String... args) {
        String str1 = "";
        String str2 = null;

        System.out.println(StringUtils.isEmpty(str1));
        System.out.println(StringUtils.isEmpty(str2));
        System.out.println(StringUtils.isBlank(str2));

    }

    public static void test1(String s){
       NumberUtils.toDouble("111.00",0.0);
    }
}
