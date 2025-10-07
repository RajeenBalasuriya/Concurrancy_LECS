package SynchronizedWays;

public class SynchronizedInstanceMethods implements ICounter {
    //use for simple instance operations
    private int counter =0;

    //only one thread can execute this method at a time per object
    public synchronized  void add(int value){
        this.counter+=value;
        System.out.println("Adding "+value+" to counter "+"-----"+Thread.currentThread().getName());
    }

    //This method also shares the same lock as add method
    public synchronized  void sub(int value){
        this.counter-=value;
        System.out.println("Subtracting "+value+" from counter "+"-----"+Thread.currentThread().getName());
    }

    public synchronized int getCount(){
        System.out.println("Getting count from counter "+counter+"-----"+Thread.currentThread().getName());
        return this.counter;

    }

}
