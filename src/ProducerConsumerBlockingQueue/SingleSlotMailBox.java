package ProducerConsumerBlockingQueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SingleSlotMailBox implements MailBox {

    private BlockingQueue<Integer> slot = new ArrayBlockingQueue<Integer>(1);

    @Override
    public void put(Integer value){
        try{
            slot.put(value);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Override
    public Integer get() {
        try {
            return slot.take();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }}
