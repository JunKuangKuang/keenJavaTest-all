package xyz.clzly.keen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeenService {
    private static final Logger logger = LogManager.getLogger(KeenService.class);
    public void print() {
        logger.warn("KeenService.print()");
    }
}
