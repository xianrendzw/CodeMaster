package tech.codemaster.bat50question.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java非阻塞队列相关的特点
 * Created by tomdeng on 16/11/2.
 */
public class QueueExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Map<Integer, Integer> map = new HashMap<>(16, 1.0f);
        for (int i = 0; i < list.size() - 4; i++) {
            map.put(list.get(i), list.get(i));
        }
        map.put(list.get(12), list.get(12));
        map.put(list.get(13), list.get(13));
        map.put(list.get(14), list.get(14));
        map.put(list.get(15), list.get(15));
    }
}
