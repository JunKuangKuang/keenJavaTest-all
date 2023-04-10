package xyz.clzly.keen;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.clzly.keen.service.KeenJCLService;
import xyz.clzly.keen.service.KeenLog4j2Service;

public class KeenMain {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        ctx.getBean(KeenLog4j2Service.class).print();
        ctx.getBean(KeenJCLService.class).print();

    }


}