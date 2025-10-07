package DiningPhilosopher;

public class Philosopher implements Runnable{
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private boolean isEaten=false;


    public Philosopher(int id , Fork leftFork, Fork rightFork){
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    @Override
    public void run(){
        while(!isEaten){
            think();
            eat();
        }
    }

    private void think (){
        System.out.println("Philosopher " + id + " is thinking.....");
        try{
            Thread.sleep((int)(Math.random() * 1000));
        }catch (InterruptedException e){
        Thread.currentThread().interrupt();
        }
    }

    private void eat() {
        boolean gotLeft = leftFork.pickUp();
        if (!gotLeft) return;

        boolean gotRight = rightFork.pickUp();
        if (!gotRight) {
            leftFork.putDown();
            return;
        }

        try {
            System.out.println("Philosopher " + id + " is eating");
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // release in reverse order
            rightFork.putDown();
            leftFork.putDown();
            isEaten=true;
            System.out.println("philsopher " + id + "has finished eating");

        }
    }
}
