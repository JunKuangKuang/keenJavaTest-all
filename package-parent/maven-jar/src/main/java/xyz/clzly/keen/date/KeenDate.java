package xyz.clzly.keen.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by  魏继扩on 2021/5/19 17:55
 */
public class KeenDate {
    private static Logger logger = LoggerFactory.getLogger(KeenDate.class);
    public static void keenCurrentTime(){
        //定义时区，可以避免虚拟机时间与系统时间不一致的问题
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Beijing"));
        logger.info(new Date(System.currentTimeMillis()).toString());
    }
    public static void main(String[] args) {
        keenCurrentTime();
    }
}