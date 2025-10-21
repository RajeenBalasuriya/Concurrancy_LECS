package ProduceConsumer1;

public class SharedResource {
    private int value;
    //avaialable marks if data is available in the shared resource or not
    private boolean available=false;

    //this will call by the producer to put items in to the shared resource
    public synchronized void put(int value){

        while(available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        this.value=value;
        available=true;
        System.out.println(Thread.currentThread().getName() + "produces " + value);
        notifyAll();

    }
    //this will call by the consumer to get value
    public synchronized int get(){

        while(!available){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        int value=this.value;
        available=false;
        System.out.println(Thread.currentThread().getName()+":"+"consumed "+value);

        notifyAll();
        return value;
    }

}
