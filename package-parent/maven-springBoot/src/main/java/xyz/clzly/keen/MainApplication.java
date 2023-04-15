package xyz.clzly.keen;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 用注解说明这是一个springboot应用
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
        KeenDate.keenCurrentTime();

        System.out.println("君匡匡真了不起！");
    }
}