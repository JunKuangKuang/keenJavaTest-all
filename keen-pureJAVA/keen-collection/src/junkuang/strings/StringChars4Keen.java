package junkuang.strings;

import java.lang.reflect.Field;

/*
 * 字符串如果字面量相同，那么它们存储的是同一个字符数组
 * */
public class StringChars4Keen {
    public static void main(String[] args) throws Exception {
        // checken();
        intern2();
    }

    public static void checken() throws Exception {

        String s1 = "junkuang";
        String s2 = new String(s1);
        String s3 = new String("junkuang");

        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);

        char[] value1 = (char[]) value.get(s1);
        char[] value2 = (char[]) value.get(s2);
        char[] value3 = (char[]) value.get(s3);

        //  字符串如果值相同，那么它们存储的是同一个字符数组
        System.out.println(value1 == value2);
        System.out.println(value2 == value3);
    }

    /*
     * 生成一个不在字符串常量池中的对象，然后比对地址
     * 先字面量声明再用intern方法，结果为false
     * */
    public static void intern() {

        /*
         * 生成一个不在字符串常量池中的对象，一共有三个方法
         * String str1 = new String("jun") + new String("kuang");
         * String str1 = new String(new char[]{'j','u','n','k','u','a','n','g'});
         */
        String str1 = new String(new byte[]{'j', 'u', 'n', 'k', 'u', 'a', 'n', 'g'});

        String str2 = "junkuang";
        str1.intern();

        System.out.println(str2 == str1);
        System.out.println(str2 == str1.intern());
    }

    /*
     * 生成一个不在字符串常量池中的对象，然后比对地址
     * 先用intern方法再字面量声明，结果为true
     * */
    public static void intern2() {
        String str1 = new String(new byte[]{'j', 'u', 'n', 'k', 'u', 'a', 'n', 'g'});

        str1.intern();
        String str2 = "junkuang";

        System.out.println(str2 == str1);
    }

}