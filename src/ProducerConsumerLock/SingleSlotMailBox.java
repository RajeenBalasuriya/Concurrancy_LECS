package ProducerConsumerLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingleSlotMailBox implements MailBox {
    private Integer slot;
    private boolean available;
    private final Lock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    @Override
    public void put(Integer value){

    }

    @Override
    public Integer get(){
        return null;
    }
}
