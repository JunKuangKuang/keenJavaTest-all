package xyz.clzly.junkuang;

import java.util.ArrayList;

/*
 * 线程优先级
 * 优先级高只是获得调度的概率增加，不一定真的就能够先运行起来
 * */
public class ThreadPriority4Keen implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // run线程
        System.out.println("run子线程"+Thread.currentThread().getName()+"      "+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        System.out.println("主线程"+Thread.currentThread().getName()+"      "+Thread.currentThread().getPriority());
        ThreadPriority4Keen threadPriority4Keen = new ThreadPriority4Keen();

        Thread[] threads=new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i]=new Thread(threadPriority4Keen,"a"+i);
        }
        threads[0].setPriority(1);
        threads[0].start();
        threads[1].setPriority(4);
        threads[1].start();
        threads[2].setPriority(5);
        threads[2].start();
        threads[3].setPriority(8);
        threads[3].start();
        threads[4].setPriority(10);
        threads[4].start();


        // Thread t5=new Thread(threadPriority4Keen);
        // Thread t6=new Thread(threadPriority4Keen);

        // 范围超出限制了会报错
        // t5.setPriority(-1);
        // t5.start();
        // t6.setPriority(11);
        // t6.start();

        System.out.println("主线程结束");
    }
}