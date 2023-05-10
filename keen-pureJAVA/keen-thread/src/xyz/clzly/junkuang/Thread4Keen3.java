package xyz.clzly.junkuang;

import java.util.concurrent.*;

/*
 * 方法三
 * 通过实现接口Callable将当前类变为线程类
 *
 * */
public class Thread4Keen3 implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        // run线程
        for (int i = 0; i < 20; i++) {
            System.out.println("junkuang子线程");
        }
        return true;
    }

    public static void main(String[] args) {
        Thread4Keen3 thread4Keen3 = new Thread4Keen3();
        // 创建执行服务
        ExecutorService exe = Executors.newFixedThreadPool(1);
        // 提交执行
        Future<Boolean> submit = exe.submit(thread4Keen3);

        try {
            // 获取结果
            Boolean res = submit.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        // 关闭服务
        exe.shutdownNow();

        // 主线程
        for (int i = 0; i < 2000; i++) {
            System.out.println("junkuang主线程");
        }

    }
}