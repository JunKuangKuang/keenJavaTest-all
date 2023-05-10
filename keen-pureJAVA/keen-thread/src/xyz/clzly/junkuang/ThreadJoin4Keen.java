package xyz.clzly.junkuang;

/*
 * 线程强制插入执行，并且只有执行完之后才会继续原先的线程
 * */
public class ThreadJoin4Keen implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // run线程
        for (int i = 0; i < 200; i++) {
            System.out.println("run子线程"+Thread.currentThread().getName()+"      "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin4Keen threadJoin4Keen = new ThreadJoin4Keen();

        Thread a = new Thread(threadJoin4Keen, "a");
        a.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 100; i++) {
            if(i==20){
                // 主线程礼让a
                a.join();
            }
            System.out.println("主线程"+Thread.currentThread().getName()+"      "+i);
        }
        System.out.println("junkuang主线程结束");
    }
}