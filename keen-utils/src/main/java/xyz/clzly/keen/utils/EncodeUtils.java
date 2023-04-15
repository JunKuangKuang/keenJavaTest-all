package xyz.clzly.keen.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*
 * 转码工具
 * */
public class EncodeUtils {
    /*
     * 将中文字符串按照utf8转码，之后再从16进制转为8进制
     * 如果失败就返回为空
     * */
    public static String chineseToCode(String context) {
        //1.url编码出字符串
        String str = null;
        try {
            str = URLEncoder.encode(context, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } finally {
            if (str == null) {
                return "";
            }
        }
        //2.获取十六进制表示的字符串
        String[] s = str.substring(1).split("%");
        StringBuffer stringBuffer = new StringBuffer();
        //3.把每个十六进制字符串转换成八进制字符串，形式为:\+数字
        for (int i = 0; i < s.length; i++) {
            stringBuffer.append("\\" + Integer.toOctalString(Integer.valueOf(s[i], 16)));
        }
        return stringBuffer.toString();
    }

    public static String codeToChinese(String context) {
        //1.获取八进制数据
        String[] split = context.substring(1).split("\\\\");
        StringBuffer stringBuffer = new StringBuffer();

        //2.把八进制转换成格式为: %+十六进制
        for (String s : split) {
            stringBuffer.append("%" + Integer.toHexString(Integer.valueOf(s, 8)).toString().toUpperCase());
        }

        //3.解码
        String decode = null;
        try {
            decode = URLDecoder.decode(stringBuffer.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } finally {
            if (decode == null) {
                return "";
            }
        }
        return decode;
    }
}