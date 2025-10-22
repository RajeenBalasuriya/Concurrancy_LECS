package ProducerConsumerBlockingQueue;

public class Consumer implements Runnable{
    private MailBox mailBox;
    public Consumer(MailBox mailBox) {
        super();
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            Integer value=mailBox.get();
            System.out.println("Consumer "+Thread.currentThread().getName()+" consumed: "+value);
        }

    }
}
