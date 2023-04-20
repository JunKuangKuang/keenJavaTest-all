package ali;

/*
* 三个线程依次输出ABC
* */
public class ThreadTest {
    public  static  String str="";
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread threadA = new Thread(new threadA());
            threadA.start();
            try {
                threadA.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread threadB = new Thread(new threadB());
            threadB.start();
            try {
                threadB.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread threadC = new Thread(new threadC());
            threadC.start();
            try {
                threadC.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        
    }
}

class threadA implements Runnable{

    @Override
    public void run() {

        System.out.println("A");


    }
}
class threadB implements Runnable{

    @Override
    public void run() {
        System.out.println("B");
    }
}
class threadC implements Runnable{

    @Override
    public void run() {
        System.out.println("C");
    }
}
