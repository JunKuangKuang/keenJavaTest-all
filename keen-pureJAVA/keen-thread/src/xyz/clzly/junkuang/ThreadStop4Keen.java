package xyz.clzly.junkuang;

/*
 * 关闭线程
 * 使用标志位来关闭其他线程
 * 不要使用stop或者destroy方法
 * */
public class ThreadStop4Keen implements Runnable {
    // 1. 设置已提供标志位
    private boolean flag =false;

    //2. 设置一个公开的停止方法修改标志位
    public void stop(){
        this.flag=true;
    }
    @Override
    public void run() {
        // run线程
        for (int i = 0; i < 200; i++) {
            if(flag){
                System.out.println("子线程被强制结束");
                return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("run子线程"+i);
        }
    }

    public static void main(String[] args) {
        ThreadStop4Keen threadStop4Keen = new ThreadStop4Keen();

        new Thread(threadStop4Keen).start();

        // 主线程
        for (int i = 0; i < 500; i++) {
            System.out.println("主"+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i==100){
                threadStop4Keen.stop();
                System.out.println("子线程结束");
            }
        }
        System.out.println("junkuang主线程结束");
    }
}