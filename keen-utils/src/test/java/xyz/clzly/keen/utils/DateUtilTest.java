package xyz.clzly.keen.utils;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtilTest {
    /**
     * 获得北京时间
     */
    @Test
    public void CurrentTime() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Beijing"));
        Date nowTime = new Date();
        SimpleDateFormat matter = new SimpleDateFormat("现在时间:yyyy年MM月dd日E HH时mm分ss秒");
        System.out.println(matter.format(nowTime));
    }

    /**
     * 输出时间
     */
    @Test
    public void printTime() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Beijing"));
        Date nowTime = new Date();
        //方法一：默认方式输出现在时间
        System.out.println(nowTime.toString());
        System.out.println(nowTime.getTime());

        //方法二：SimpleDateFormat方式，完整输出现在时间
        SimpleDateFormat matter = new SimpleDateFormat("现在时间:yyyy年MM月dd日E HH时mm分ss秒");
        System.out.println(matter.format(nowTime));

        // 方法三：指定时间
        Long time = 1643133590186L;
        Date date = new Date();
        date.setTime(time);
        System.out.println(date);
    }

    /**
     * 将任何已知的时间格式字符串转为date
     */
    @Test
    public void parseDateByString() {
        // Sun Dec 13 00:00:00 CST 2021
        Date date = DateUtil.parseDateByString("Jan 11, 2022 8:25:06 PM");
        // Date date = DateUtil.parseDateByString("1640718704568");

        if (date != null) {
            SimpleDateFormat matter = new SimpleDateFormat("转换后时间:yyyy年MM月dd日E HH时mm分ss秒");
            System.out.println(matter.format(date));
        }
    }


}