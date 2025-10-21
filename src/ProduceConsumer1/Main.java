package ProduceConsumer1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SharedResource sharedResource = new SharedResource();
        int itemCount = 10;

        Thread producer = new Thread(new Producer(sharedResource, itemCount),
                "Producer");

        Thread consumer = new Thread(new Consumer(sharedResource, itemCount),"Consumer");

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();



    }
}
