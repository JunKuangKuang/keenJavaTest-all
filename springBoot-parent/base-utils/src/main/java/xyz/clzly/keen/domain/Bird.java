package xyz.clzly.keen.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Bird {

    private  static Logger logger = LoggerFactory.getLogger(Bird.class);

    public void move() {
        logger.info("我会飞的更高 嗷～");
    }


}