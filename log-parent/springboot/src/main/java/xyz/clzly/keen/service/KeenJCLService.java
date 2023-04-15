package xyz.clzly.keen.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class KeenJCLService {
    private static Log logger = LogFactory.getLog(KeenJCLService.class);

    public void print() {
        logger.info("调用KeenJCLService类打印日志");
    }
}
