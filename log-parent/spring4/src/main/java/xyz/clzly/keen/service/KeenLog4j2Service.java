package xyz.clzly.keen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class KeenLog4j2Service {

    private static final Logger logger = LogManager.getLogger(KeenLog4j2Service.class);

    public void print() {
        logger.info("调用KeenLog4j2Service类打印日志");
    }
}
