package SynchronizedWays;

public class SynchronizedInstanceBlocks implements ICounter {
    private int counter =0;

    @Override
    public void add(int value) {
        //This code can run withouth synchronzied
        System.out.println("Running without synchronized "+"-"+Thread.currentThread().getName() );

        synchronized (this) {
            counter+=value;
            System.out.println("Added "+value +" to "+Thread.currentThread().getName());
        }
        //This code also can run without synchronization
        System.out.println("Running without synchronized "+"-"+Thread.currentThread().getName() );
    }

    @Override
    public void sub(int value) {
        System.out.println("Running without synchronized "+"-"+Thread.currentThread().getName() );
        synchronized (this) {
            counter-=value;
        }
        System.out.println("Subtracted "+value +" from "+Thread.currentThread().getName());
        System.out.println("Running without synchronized "+"-"+Thread.currentThread().getName() );
    }

    @Override
    public int getCount(){
        return counter;
    }
}
