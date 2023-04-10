package xyz.clzly.keen.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtils {
    private static Logger logger = LoggerFactory.getLogger(LoggingUtils.class);

    public static boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public static boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public static boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    public static void debug(Class clazz, String msg, Object... args) {
        if (clazz != null) {
            logger = LoggerFactory.getLogger(clazz);
        }
        if (logger.isDebugEnabled()) {
            logger.debug(msg, args);
        }
    }

    public static void info(Class clazz, String msg, Object... args) {
        if (clazz != null) {
            logger = LoggerFactory.getLogger(clazz);
        }
        if (logger.isInfoEnabled()) {
            logger.info(msg, args);
        }
    }

    public static void error(Class clazz, String msg, Object... args) {
        if (clazz != null) {
            logger = LoggerFactory.getLogger(clazz);
        }
        if (logger.isErrorEnabled()) {
            logger.error(msg, args);
        }
    }
}