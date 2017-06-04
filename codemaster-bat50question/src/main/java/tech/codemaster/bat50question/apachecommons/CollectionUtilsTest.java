package tech.codemaster.bat50question.apachecommons;

import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;

/**
 * @author Tom Deng
 * @date 2017-03-30
 **/
public class CollectionUtilsTest {
    public static void main(String... args) {
        Map<String, String> map = Maps.newHashMap();
        System.out.println(MapUtils.isEmpty(map));
        MapUtils.getString(map,"","");
        //MapUtils.getString(map,"","")
    }
}
