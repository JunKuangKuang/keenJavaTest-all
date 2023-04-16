package xyz.clzly.safe.ticket;

/*
 * 线程同步的情况下，进行抢票
 * 多个需要同时访问此对象的线程，会进入对象的等待池形成队列，要等到前面的线程执行完毕，下一个线程才使用
 * */
public class TicketSafe4Thread2 implements Runnable {
    private Integer ticketNums = 10;


    @Override
    public void run() {
        synchronized (ticketNums) {
            while (true) {
                if (ticketNums <= 0) {
                    break;
                }
                try {
                    Thread.sleep(200);

                    buy();


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void buy() {
        System.out.println(Thread.currentThread().getName() + "拿到的票序号为：" + ticketNums--);
    }


    public static void main(String[] args) {
        TicketSafe4Thread2 ticketSave = new TicketSafe4Thread2();
        new Thread(ticketSave, "君匡").start();
        new Thread(ticketSave, "张三").start();
        new Thread(ticketSave, "keen").start();

    }
}