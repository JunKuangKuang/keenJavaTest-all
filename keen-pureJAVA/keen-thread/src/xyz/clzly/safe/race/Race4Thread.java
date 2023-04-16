package xyz.clzly.safe.race;

/*
* 测试龟兔赛跑
*
* */
public class Race4Thread implements  Runnable{
    private static String winner;


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(gameOver(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑步数为："+i);
        }
    }

    private boolean gameOver(int steps) {
        if(winner!=null){
            return true;
        }else if(steps>=100){
            winner=Thread.currentThread().getName();
            System.out.println("胜利的人是"+winner);
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        Race4Thread race= new Race4Thread();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
        // new Thread(race,"keen").start();

    }
}