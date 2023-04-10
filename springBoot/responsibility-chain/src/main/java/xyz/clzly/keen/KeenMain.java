package xyz.clzly.keen;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import xyz.clzly.keen.process.abstruct.Leader;
import xyz.clzly.keen.process.entity.LeaveInfo;
import xyz.clzly.keen.process.extend.Director;
import xyz.clzly.keen.process.extend.GeneralManager;
import xyz.clzly.keen.process.extend.Manager;
import xyz.clzly.keen.process.extend.ViceGeneralManager;

// 用注解说明这是一个springboot应用
@ComponentScan(basePackages = {
        "xyz.clzly"
})
// 指定的配置文件不存在是否报错，默认是false。当设置为 true 时，若该文件不存在，程序不会报错
@PropertySource(value = {
        "classpath:start.properties"
}, ignoreResourceNotFound = true)
@SpringBootApplication
public class KeenMain {
    public static void main(String[] args) {
        // 解除JUL的绑定
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        SpringApplication.run(KeenMain.class);

        // 构建负责人链表
        Leader lead=new Leader("当前负责人") {
            @Override
            public void handleLeave(LeaveInfo leaveInfo) {
                if (this.nextLeader != null) {
                    //如果有后继对象, 让后继对象处理
                    this.nextLeader.handleLeave(leaveInfo);
                }else{
                    // 否则报错
                    System.out.println("你去走流程审批!");
                }
            }
        };

        //主任
        Leader director = new Director("张三");
        //经理
        Leader manager = new Manager("李四");
        //副总经理
        Leader viceGeneralManager = new ViceGeneralManager("王五");
        //总经理
        Leader generalManager = new GeneralManager("赵六");
        //也可以存到容器里,并进行遍历,一样


        //组织责任链对象的关系
        lead.setNextLeader(director);
        director.setNextLeader(manager);//主任的上司: 经理
        manager.setNextLeader(viceGeneralManager);//经理的上司: 副总经理
        viceGeneralManager.setNextLeader(generalManager);//副总经理的上司: 总经理


        // 开始请假操作
        // 先由低层开始处理, 可以处理就处理, 处理不了就上报

        // 请假1天应该由主任处理, 看看结果!
        lead.handleLeave(new LeaveInfo("Alex", 1, "去玩耍!"));
        lead.handleLeave(new LeaveInfo("Bob", 3, "去玩耍!"));
        lead.handleLeave(new LeaveInfo("Caddy", 8, "去玩耍!"));
        // 请假15天应该由副总经理处理, 看看结果!
        lead.handleLeave(new LeaveInfo("Tom", 15, "去美国探亲!"));
        lead.handleLeave(new LeaveInfo("Wess", 31, "去美国探亲!"));
        System.out.println("君匡匡真了不起！");
    }
}