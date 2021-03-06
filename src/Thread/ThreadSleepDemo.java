package Thread;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 01:38
 **/

public class ThreadSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("thread A is waiting to get lock");
                synchronized(lock){
                    try{
                        System.out.println("thread A get lock");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        lock.wait(1000);
                        System.out.println("thread A is done");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("thread B is waiting to get lock");
                synchronized(lock){
                    try{
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10 ms");
                        Thread.sleep(10);
                        System.out.println("thread B is done");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
