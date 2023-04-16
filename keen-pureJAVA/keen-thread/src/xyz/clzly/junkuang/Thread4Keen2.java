package xyz.clzly.junkuang;

/*
 * 方法二
 * 通过实现接口
 * 避免单继承的局限性
 * */
public class Thread4Keen2 implements Runnable {
    @Override
    public void run() {
        // run线程
        for (int i = 0; i < 20; i++) {
            System.out.println("run子线程");
        }
    }

    public static void main(String[] args) {
        Thread4Keen2 thread4Keen2 = new Thread4Keen2();

        new Thread(thread4Keen2).start();

        // 主线程
        for (int i = 0; i < 2000; i++) {
            System.out.println("主");
        }
    }
}