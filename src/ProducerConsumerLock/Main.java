package ProducerConsumerLock;

public class Main {
    public static void main(String[] args) {
        MailBox mailBox = new SingleSlotMailBox();
        Thread t1 = new Thread(new Producer(mailBox),"producer");
        Thread t2 = new Thread(new Consumer(mailBox),"consumer");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
