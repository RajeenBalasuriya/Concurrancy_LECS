package DiningPhilosopher;

public class Main {
    public static void main(String[] args) {

        final int NUM_PHILOSOPHERS = 5;

        //create folks
        Fork[] forks = new Fork[NUM_PHILOSOPHERS];

        //add forks to the table
        for(int i =0;i<NUM_PHILOSOPHERS;i++){
            forks[i] = new Fork();
        }

        //create philosophers
        Thread[] philosophers = new Thread[NUM_PHILOSOPHERS];
        for(int i =0;i<NUM_PHILOSOPHERS;i++){
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i+1)%NUM_PHILOSOPHERS];

            philosophers[i]= new Thread(new Philosopher(i,leftFork,rightFork),"Philosopher -"+i);
        }

        for(Thread philosopher : philosophers){
            philosopher.start();
        }


    }

}
