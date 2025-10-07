package SynchronizedWays;

import java.util.Random;

public class Counter implements Runnable{
    private ICounter counter;

    public Counter(ICounter counter){
        this.counter = counter;
    }
    @Override
    public void run(){
       counter.add((int) (Math.random() * 10));
       counter.sub((int) (Math.random() * 10));
       System.out.println(counter.getCount() +" "+ Thread.currentThread().getName());

    }
}
