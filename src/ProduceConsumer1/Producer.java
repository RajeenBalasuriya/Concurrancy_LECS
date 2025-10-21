package ProduceConsumer1;

public class Producer implements Runnable {
    private final SharedResource sharedResource;
    private final int itemCount;

    public Producer(SharedResource sharedResource, int itemCount){
        this.sharedResource=sharedResource;
        this.itemCount=itemCount;
    }

    @Override
    public void run(){
        try{
            for(int i=0;i<itemCount;i++){
                sharedResource.put(i);
              //  System.out.println(Thread.currentThread().getName() +"produces" +i);
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
