package xyz.clzly.keen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeenSlf4jService {
    private static Logger logger = LoggerFactory.getLogger(KeenSlf4jService.class);

    public  void print() {
        logger.info("调用KeenSlf4jService类打印日志：");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}
