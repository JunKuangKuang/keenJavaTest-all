package xyz.clzly.keen.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 实现了这个接口（ApplicationContextAware）之后，这个类就可以方便获得ApplicationContext中的所有bean。
 * 有三个注意点：
 *      1. 注册方法类
 *      2. 使用静态对象
 * */
//注册方法类，扫描进容器
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    // 一定要使用静态对象
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        applicationContext = arg0;
        System.out.println("applicationContext初始化完毕。");
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }


    //获取Bean
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name){
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        if(applicationContext==null){
            System.out.println("applicationContext是空的");
            return null;
        }
        return applicationContext.getBean(clazz);
    }

}
