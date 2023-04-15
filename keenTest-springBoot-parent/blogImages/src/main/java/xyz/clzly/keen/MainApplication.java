package xyz.clzly.keen;

import com.apple.eawt.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import xyz.clzly.keen.process.BlogHandler;

import java.util.TimeZone;

// 用注解说明这是一个springboot应用
@ImportResource(locations = {
        "classpath:spring-main.xml"
})
@ComponentScan(basePackages = {
        "xyz.clzly"
})
// 指定的配置文件不存在是否报错，默认是false。当设置为 true 时，若该文件不存在，程序不会报错
@PropertySource(value = {
        "classpath:start.properties"
}, ignoreResourceNotFound = false)
@SpringBootApplication
public class MainApplication {

    private static Logger logger = LoggerFactory.getLogger(MainApplication.class);


    public static void main(String[] args) {
        // 解除JUL的绑定
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        // 定义时区
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Beijing"));

        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MainApplication.class)
                .web(WebApplicationType.NONE)
                .run();

        logger.info("君匡匡真了不起！");

        BlogHandler blogHandler = ctx.getBean(BlogHandler.class);
        blogHandler.setBlogRootPath("/Volumes/KeenMacPlus/Projects/javaWeb/keenJavaTest-all/keenTest-springBoot-parent/blogImages/src/main/resources");
        blogHandler.setBlogImagesRootPath("/images");
        blogHandler.dealImages();


        // 退出并结束
        System.out.println("君匡匡真了不起！");
        SpringApplication.exit(ctx, () -> 0);
    }
}