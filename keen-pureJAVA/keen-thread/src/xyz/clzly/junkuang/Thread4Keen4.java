package xyz.clzly.junkuang;


import java.util.concurrent.*;

/*
 * 方法四
 * 通过FutureTask实例来实现接口Callable
 * 也可以拿到反馈结果，此时不需要使用线程池
 * */
public class Thread4Keen4 {
    public static void main(String[] args) throws Exception {
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("junkuang子线程");
                Thread.sleep(1000 * 5);
                return new String("junkuangkuang子线程结束");
            }
        });

        // 创建线程对象实例并且进入就绪状态
         new Thread(task).start();


        // 在主线程中，为了获取t线程的返回结果要调用get()方法
        Object obj = task.get();
        System.out.println("子线程执行结果:" + obj);

        // 而get()方法执行会导致“当前线程阻塞”
        // 也就是主线程必须等待get()方法执行完毕才能继续执行
        System.out.println("junkuang主线程");
    }
}