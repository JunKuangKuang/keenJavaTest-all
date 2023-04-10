package xyz.clzly.keen.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author junkuang
 * @apiNote 具体使用的样例可以查看测试文件KeenJsonTest
 * */
public class KeenJsonUtil {


    /**
     * 对象转json字符串，会格式化分行且打印到控制台
     * 注意空字符串不会转成String的，而且重复数据会出现$ref
     *
     * SerializerFeature详解
     * https://blog.csdn.net/u010246789/article/details/52539576
     */
    public static String toJSONString(Object o) {

        String s = JSON.toJSONString(o, true);
        System.out.println("KeenJson将对象转为json字符串，结果为: " + s);
        return s;
    }

    /**
     * 从字符串转为类对象
     */
    public static Object parseObject(String s, Class c) {
        Object object = JSON.parseObject(s, c);
        return object;
    }

    /**
     * 从字符串转为类对象
     */
    public static JSONObject parseJsonObject(String s) {
        JSONObject object = JSON.parseObject(s);
        return object;
    }

    /**
     * 将对象转为json文件
     * 不需要HttpSession的话可以直接写绝对路径即可
     */
    public static void write(Object o, String pathStr, String fileName) {
        String jsonString = JSON.toJSONString(o, true);
        File file = null;
        try {
            //创建文件夹
            file = new File(pathStr);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            System.out.println("创建文件夹失败");
            return ;
        }

        try {
            // 创建文件名
            file = new File(pathStr, fileName);
            // 创建文件,并且完成覆盖写入
            FileOutputStream outputStream = new FileOutputStream(file);
            // 写入字符串
            outputStream.write(jsonString.getBytes(StandardCharsets.UTF_8));
            // 关闭文件流
            outputStream.close();
        } catch (Exception ex) {
            System.out.println("写入文件夹失败");
            return;
        }
        System.out.println("生成json文件："+pathStr+fileName);
    }

    /**
     * 将文件转为字符串
     */
    public static String read(String jsonFilePath) {
        if (jsonFilePath == null) {
            throw new IllegalArgumentException("资源文件路径不能为空");
        }
        String jsonStr = "";
        try {
            File jsonFile = new File(jsonFilePath);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将两个json格式的字符串合并之后，再返回json化的字符串
     * json合并 相同的字段的话，最后只保留s2中的
     * 如果两个入参都是（null || 空字符串）,最后返回一对儿大括弧
     */
    public static String mergeJsonObject(String s1, String s2) {
        if (StringUtils.isBlank(s1)) {
            s1 = "{}";
        }
        if (StringUtils.isBlank(s2)) {
            s2 = "{}";
        }
        JSONObject jsonObject1 = KeenJsonUtil.parseJsonObject(s1);
        JSONObject jsonObject2 = KeenJsonUtil.parseJsonObject(s2);
        JSONObject result = new JSONObject();
        result.putAll(jsonObject1);
        result.putAll(jsonObject2);
        return result.toJSONString();
    }
}