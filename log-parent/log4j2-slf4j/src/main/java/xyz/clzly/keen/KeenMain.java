package xyz.clzly.keen;


import xyz.clzly.keen.service.KeenLog4j2Service;
import xyz.clzly.keen.service.KeenSlf4jService;
import xyz.clzly.keen.utils.LoggingUtils;

public class KeenMain {
    public static void main(String[] args) {
        new KeenLog4j2Service().print();
        new KeenSlf4jService().print();
        LoggingUtils.info(KeenMain.class, "打印日志");
        LoggingUtils.info(KeenMain.class, "【方法】{}", "main");
    }
}
