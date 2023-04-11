package xyz.clzly.keen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeenLog4j2Service {

    private static final Logger logger = LogManager.getLogger(KeenLog4j2Service.class);
    public  void print() {
        logger.info("调用KeenLog4j2Service类打印日志：");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}
