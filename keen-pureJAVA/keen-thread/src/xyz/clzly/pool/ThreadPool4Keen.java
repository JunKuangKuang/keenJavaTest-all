package xyz.clzly.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 从1.5开始提供了ExecutorService和Executor
* 线程池，不需要频繁创建和销毁线程，
* 而是从池中获取线程，等用完之后不销毁而是放回原来的线程池中
* 好处是提高了响应速度，减少了创建新线程所需要的时间
* 方便了线程管理，可以控制最大线程数和存活时间等属性
* */
public class ThreadPool4Keen {
    /*
    * corePoolSize: 核心池子的大小
    * maximumPoolSize: 最大线程数
    * keepAliveTime： 线程在没有任务时最多保持多长时间后会终止
    * */

    public static void main(String[] args) {
        // 参数为线程池的大小
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        // 运行的线程数（4）小于线程池大小（10）的时候会完整地输出四个线程名字
        // 而运行的线程数（4）大于线程池大小（2）的时候，只会输出两个线程的名字，并且输出两遍
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());

        executorService.shutdown();

    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}