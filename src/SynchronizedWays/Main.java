package SynchronizedWays;

public class Main {
    public static void main(String [] args){

        Counter c1 = new Counter(new SynchronizedInstanceBlocks());

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(c1);
        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c1);
        Thread t6 = new Thread(c1);

        t2.start();
        t1.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();



    }
}
