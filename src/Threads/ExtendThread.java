package Threads;

public class ExtendThread extends Thread {

    public ExtendThread(String name ){
        this.setName(name);
    };
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
