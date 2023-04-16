package xyz.clzly.junkuang;

/*
线程状态。 线程可以处于以下状态之一：
NEW:             尚未启动的线程处于此状态。就是刚创建好，还没start
RUNNABLE：       在Java虚拟机中执行的线程处于此状态。就是就绪状态，已经start
BLOCKED：        被阻塞等待监视器锁定的线程处于此状态。
WAITING：        正在等待另一个线程执行特定动作的线程处于此状态。
TIMED_WAITING：  正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。调用了sleep
TERMINATED：     已退出的线程处于此状态。线程运行结束后，无法再次启动的状态
一个线程可以在给定时间点处于一个状态。 这些状态是不反映任何操作系统线程状态的虚拟机状态。
*/
public class ThreadState4Keen implements Runnable {
    @Override
    public void run() {
        // run线程
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("run子线程");
        }
    }

    public static void main(String[] args) {

        ThreadState4Keen threadState4Keen = new ThreadState4Keen();

        Thread a = new Thread(threadState4Keen, "a");
        System.out.println(a.getState());

        a.start();
        System.out.println(a.getState());

        while(a.getState()!= Thread.State.TERMINATED){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(a.getState());
        }

        System.out.println(a.getState());
        System.out.println("主线程结束");
    }
}