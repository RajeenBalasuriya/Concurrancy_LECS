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
        try{
            lock.lock();//aquire the lock
            while(available){//if available true means slot is full
                try{
                    notEmpty.await();//producer is put WAITING on notEmpty condition
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            //producer will come here only if the slot is empty
            this.slot = value;
            this.available = true;
            notFull.signalAll();//consumers who are in WAITING on notFull condition will woken up
        }finally {
            lock.unlock();
        }

    }

    @Override
    public Integer get() {
        try {
            lock.lock();
            while (!available) {//if the slot is empty
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Integer value = this.slot;
            this.available = false;
            return value;

        } finally {
            lock.unlock();
        }
    }}
