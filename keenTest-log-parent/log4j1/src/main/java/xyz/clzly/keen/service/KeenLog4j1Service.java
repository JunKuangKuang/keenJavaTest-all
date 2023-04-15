package xyz.clzly.keen.service;

import org.apache.log4j.Logger;
/**
 * 使用log4j1的日志门面`Log4j(Log for java)`版本`1.xx`
 * */
public class KeenLog4j1Service {

    private static Logger logger = Logger.getLogger(KeenLog4j1Service.class);
    public  void print() {
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}
