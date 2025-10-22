package ProducerConsumerLock;

public class Producer implements Runnable {
    private MailBox mailBox;
    public Producer(MailBox mailBox) {
        super();
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            mailBox.put(i);
            System.out.println(Thread.currentThread().getName() +" produces : "+i);
        }
    }
}
