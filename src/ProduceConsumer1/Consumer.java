package ProduceConsumer1;

public class Consumer implements Runnable {
    private final SharedResource sharedResource;
    private final int itemCount;
    public Consumer(SharedResource sharedResource,int itemCount) {
        this.sharedResource = sharedResource;
        this.itemCount =itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                int value = sharedResource.get();
              //  System.out.println(Thread.currentThread().getName()+":"+value);
                Thread.sleep(150); // Simulate consumption time (slower)
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() +
                    " interrupted");
        }
    }


}
