package tech.codemaster.bat50question.json;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @author zhiwei.deng
 * @date 2017-05-31
 **/
public class FastJsonTest {

    public static void main(String... args) {
        List<Object> list = new ArrayList<>();
        list.add(111);
        list.add(12);
        list.add(0.11);
        list.add(22);
        list.forEach(System.out::println);

        String text = JSON.toJSONString(list);
        System.out.println(JSON.parseArray(text));
    }
}
