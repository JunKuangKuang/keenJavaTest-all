package xyz.clzly.keen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

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
}, ignoreResourceNotFound = true)
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
        System.out.println("君匡匡真了不起！");
    }
}