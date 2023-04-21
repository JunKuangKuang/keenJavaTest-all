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
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import xyz.clzly.keen.process.BlogHandler;
import xyz.clzly.keen.utils.ImagesUtils;
import xyz.clzly.keen.utils.MemoryUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
@EnableAsync
@EnableTransactionManagement
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


        // String[] beanDefinitionNames = ctx.getBeanDefinitionNames();   //查询出容器中所有的实例对象名称
        // for (String beanDefinitionName : beanDefinitionNames) {
        //     System.out.println(beanDefinitionName);
        // }
        long stime = System.currentTimeMillis();
        MemoryUtils.getThreadNum();
        BlogHandler blogHandler = ctx.getBean(BlogHandler.class);
        blogHandler.setBlogRootPath("/Volumes/KeenMacPlus/Blog/0keen/public");
        blogHandler.setBlogImagesRootPath("/images");
        blogHandler.dealImages();
        MemoryUtils.getThreadNum();

        long etime = System.currentTimeMillis();

        logger.info("压缩并添加水印花费了" + (etime - stime) / 1000 + "s");


        // 退出并结束
        logger.info("君匡匡真了不起！");

    }
}