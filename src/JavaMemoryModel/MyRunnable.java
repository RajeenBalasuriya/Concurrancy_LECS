package JavaMemoryModel;

public class MyRunnable implements Runnable{

    private int count =0;

    @Override
    public synchronized void run(){
        for(int i=0;i<1_000_000;i++){
            this.count++;
        }

        System.out.println(Thread.currentThread().getName()+"  "+count);
    }
}
