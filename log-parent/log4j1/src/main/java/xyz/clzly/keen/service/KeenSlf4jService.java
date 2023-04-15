package xyz.clzly.keen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 使用的是Slf4j(Simple Logging Facade for Java)作为门面
 * */
public class KeenSlf4jService {
    private static Logger logger = LoggerFactory.getLogger(KeenSlf4jService.class);

    public  void print() {
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}
