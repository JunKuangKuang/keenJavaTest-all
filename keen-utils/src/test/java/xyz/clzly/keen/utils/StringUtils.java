package xyz.clzly.keen.utils;

import org.junit.Test;

public class StringUtils {
    /**
     * 数值n如果 >0 则会执行切割 n-1次,也就是说执行的次数不会超过输入的数值次.数组长度不会大于切割次数,
     * 输入limit为数字1,切割执行1-1次 ,也就是0次,所以切割后的数组长度仍然是1,也就是原来的字符串
     * https://blog.csdn.net/qq_41785135/article/details/82840626
     * */
    @Test
    public void split(){
        String s = "123|123123|12313|";
        String[] split = s.split("\\|");
        System.out.println();
    }
}
