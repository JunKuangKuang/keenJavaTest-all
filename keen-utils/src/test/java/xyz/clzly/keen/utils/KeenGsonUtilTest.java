package xyz.clzly.keen.utils;

import com.google.gson.GsonBuilder;
import org.junit.Test;
import xyz.clzly.keen.domain.Demo;

public class KeenGsonUtilTest {

   final private static Demo demoObject = new Demo(3, "demo=Name");

    @Test
    public void toJSONString() {

        // 未能正常输出结果 {"num":3,"name":"demo\u003dName"}
        System.out.println(new GsonBuilder().create().toJson(demoObject));

        // 正常输出结果 {"num":3,"name":"demo=Name"}
        System.out.println(KeenGsonUtil.toJSONString(demoObject));
    }
}