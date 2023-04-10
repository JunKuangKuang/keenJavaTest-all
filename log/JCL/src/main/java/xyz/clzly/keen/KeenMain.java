package xyz.clzly.keen;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 作为门面，自动去找实现
 * 先找Log4j1，如果没有再找JUL
 * */
public class KeenMain {

    private static Log logger = LogFactory.getLog(KeenMain.class);

    public static void print(){
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        //如果不配置JUL的话，下面的内容是打印不出来的
        logger.debug("debug");
        logger.trace("trace");
    }

    public static void main(String[] args) {
        KeenMain.print();
    }
}