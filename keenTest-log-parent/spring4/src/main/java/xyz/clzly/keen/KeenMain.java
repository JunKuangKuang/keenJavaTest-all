package xyz.clzly.keen;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.clzly.keen.service.KeenJCLService;
import xyz.clzly.keen.service.KeenLog4j2Service;
import xyz.clzly.keen.service.KeenSlf4jService;

public class KeenMain {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        ctx.getBean(KeenJCLService.class).print();
        ctx.getBean(KeenSlf4jService.class).print();
        ctx.getBean(KeenLog4j2Service.class).print();

    }


}