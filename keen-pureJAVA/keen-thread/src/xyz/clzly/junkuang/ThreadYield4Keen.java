package xyz.clzly.junkuang;

/*
 * 线程礼让，让当前执行的线程暂停返回就绪状态，但是不阻塞
 * 允许CPU重新调度其他线程，但是不一定成功
 * */
public class ThreadYield4Keen implements Runnable {
    @Override
    public void run() {
        // run线程
        for (int i = 0; i < 10; i++) {
            if(i==5 && "a".equals(Thread.currentThread().getName())){
                // 线程a礼让b
                Thread.yield();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("run子线程"+Thread.currentThread().getName()+"      "+i);
        }
    }

    public static void main(String[] args) {
        ThreadYield4Keen threadYield4Keen = new ThreadYield4Keen();

        new Thread(threadYield4Keen,"a").start();
        new Thread(threadYield4Keen,"bBBBBBB").start();
        System.out.println("主线程结束");
    }
}