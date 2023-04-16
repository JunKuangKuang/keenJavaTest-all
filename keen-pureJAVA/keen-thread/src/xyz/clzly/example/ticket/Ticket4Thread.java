package xyz.clzly.example.ticket;

/*
* 测试抢购火车票
* 不加控制的话，会出现超发和不合规内容
* */
public class Ticket4Thread implements  Runnable{
    private int ticketNums=10;


    @Override
    public void run() {
        while (true){
            if(ticketNums<=0){
                break;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName()+"拿到的票序号为："+ticketNums--);
        }
    }


    public static void main(String[] args) {
        Ticket4Thread ticket= new Ticket4Thread();
        new Thread(ticket,"君匡").start();
        new Thread(ticket,"张三").start();
        new Thread(ticket,"keen").start();

    }
}