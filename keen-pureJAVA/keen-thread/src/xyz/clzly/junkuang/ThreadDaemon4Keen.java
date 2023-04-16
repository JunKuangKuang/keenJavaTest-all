package xyz.clzly.junkuang;

/*
 * 守护线程
 * 虚拟机确保用户线程执行完毕，而不用等待守护线程执行完毕
 * 如垃圾回收、内存监控，操作记录等
 * */
public class ThreadDaemon4Keen implements Runnable {
    @Override
    public void run() {
        // run线程
        while(true){
            System.out.println("君匡会一直陪着你");
        }
    }

    public static void main(String[] args) {
        // 设置一个守护线程
        Thread daemon = new Thread(new ThreadDaemon4Keen());
        daemon.setDaemon(true);
        daemon.start();

        // 默认是用户的子线程
        Thread4Keen2 thread4Keen2 = new Thread4Keen2();
        new Thread(thread4Keen2).start();

    }
}