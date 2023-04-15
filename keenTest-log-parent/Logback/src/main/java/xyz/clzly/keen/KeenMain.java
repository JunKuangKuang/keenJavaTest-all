package xyz.clzly.keen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * logback的官方门面就是slf4j
 * */
public class KeenMain {
    private static Logger logger = LoggerFactory.getLogger(KeenMain.class);

    public static void main(String[] args) {
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}