package  xyz.clzly.keen;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KeenMain {
    // 创建一个记录器名为xyz.clzly.keen的日志
    // 存在层级关系，倘若给记录器名为xyz.clzly的自定义日志设置级别，也会影响到这里
    public static Logger log = Logger.getLogger("xyz.clzly.keen");
    public static void main(String[] args) {
        // 解除JUL的绑定
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        log.info("info");    //信息日志
        log.warning("warn"); //警告日志
        log.log(Level.SEVERE,"error"); //严重日志
    }
}