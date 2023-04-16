package xyz.clzly.junkuang;

/*
 * 方法一
 * 通过继承Thread类，重写run方法
 *
 * start之后不一定立刻执行，由cpu进行调度
 * */
public class Thread4Keen1 extends Thread {
    @Override
    public void run() {
        // run线程
        for (int i = 0; i < 20; i++) {
            System.out.println("run子线程");
        }
    }

    public static void main(String[] args) {
        new Thread4Keen1().start();
        // 主线程
        for (int i = 0; i < 2000; i++) {
            System.out.println("主");
        }
    }
}