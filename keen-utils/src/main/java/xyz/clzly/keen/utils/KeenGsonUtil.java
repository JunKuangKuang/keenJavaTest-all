package xyz.clzly.keen.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author junkuang
 * @apiNote 具体使用的样例可以查看测试文件KeenJsonTest
 * */
public class KeenGsonUtil {

    /**
     * 对象转json字符串
     * 为防止用Gson序列化时，内容的“=”被处理成“\u003d”，需要指定生成的Gson对象。
     */
    public static String toJSONString(Object o) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(o);
    }


}