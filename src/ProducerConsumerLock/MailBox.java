package ProducerConsumerLock;

public interface MailBox {
    void put (Integer value);
    Integer get();
}
