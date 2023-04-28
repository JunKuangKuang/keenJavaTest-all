package xyz.clzly.keen.utils;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import xyz.clzly.keen.domain.Demo;

public class KeenJsonUtilTest {
    private static Demo demoObject = new Demo(3, "demoName");

    @Test
    public void toJSONString() {
        KeenJsonUtil.toJSONString(demoObject);
    }

    @Test
    public void parseObject() {
        String s1 = "{\n" +
                "\t\"name\":\"demoName\",\n" +
                "\t\"num\":3\n" +
                "}";
        Demo demo = (Demo) KeenJsonUtil.parseObject(s1, Demo.class);
        System.out.println(demo);
    }

    @Test
    public void write() {
        Demo fileDemo = new Demo(1, "fileDemo");
        KeenJsonUtil.write(fileDemo, "/Users/junkuang/projects-keen/keenJavaTest-all/keen-utils/src/test/java/xyz/clzly/keen/files", "fileDemo.json");
    }

    @Test
    public void read() {
        String s1 = KeenJsonUtil.read("/Users/junkuang/projects-keen/keenJavaTest-all/keen-utils/src/test/java/xyz/clzly/keen/files/fileDemo.json");
        System.out.println(s1);
    }

    @Test
    public void mergeJsonObject() {
        Demo fileDemo = new Demo(1, "fileDemo");
        String s1 = KeenJsonUtil.mergeJsonObject(JSON.toJSONString(fileDemo), JSON.toJSONString(demoObject));
        System.out.println(s1);
    }


}