package DiningPhilosopher;

public class Philosopher implements Runnable{
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;


    public Philosopher(int id , Fork leftFork, Fork rightFork){
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    @Override
    public void run(){

    }

    private void think (){
        System.out.println("Philosopher " + id + " is thinking.....");
        try{
            Thread.sleep((int)(Math.random() * 1000));
        }catch (InterruptedException e){
        Thread.currentThread().interrupt();
        }
    }

    private void eat(){
        //Attempt to aquire both folks
        if(leftFork.pickUp()){
            if(rightFork.pickUp()){
                System.out.println("Philosopher " + id + " is eating");
                try{
                    Thread.sleep((int)(Math.random() * 1000));
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            rightFork.putDown();
        }
        leftFork.putDown();
    }
}
