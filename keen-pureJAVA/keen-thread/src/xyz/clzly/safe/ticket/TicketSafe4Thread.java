package xyz.clzly.safe.ticket;

/*
* 线程同步的情况下，进行抢票
* 多个需要同时访问此对象的线程，会进入对象的等待池形成队列，要等到前面的线程执行完毕，下一个线程才使用
* */
public class TicketSafe4Thread implements  Runnable{
    private int ticketNums=10;


    @Override
    public void run() {
        while (true){
            if(ticketNums<=0){
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

    // 同步非run方法锁的是this对象，能够做到顺序抢票没有重复票了，
    // 但是会出现负数！！！
    private synchronized  void buy(){
        System.out.println(Thread.currentThread().getName()+"拿到的票序号为："+ticketNums--);
    }


    public static void main(String[] args) {
        TicketSafe4Thread ticketSave= new TicketSafe4Thread();
        new Thread(ticketSave,"君匡").start();
        new Thread(ticketSave,"张三").start();
        new Thread(ticketSave,"keen").start();

    }
}