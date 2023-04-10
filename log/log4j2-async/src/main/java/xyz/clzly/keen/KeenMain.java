package xyz.clzly.keen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.clzly.keen.service.KeenService;


public class KeenMain {

    // 定义日志记录器对象
    private static final Logger logger = LogManager.getLogger(KeenMain.class);

    public static void main(String[] args) {
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        //如果不配置的话，下面的内容是打印不出来的
        logger.debug("debug");
        logger.trace("trace");

        // 指定路径的内容会输出到指定文件中
        new KeenService().print();
    }
}