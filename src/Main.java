import Threads.ExtendThread;
import Threads.RunnableObject;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //this thread is made using extending thread class
    Thread t1 = new ExtendThread("thread1");
    t1.start();

    // this thread is using runnable object and pass it to the thread
    Runnable r1 = new RunnableObject();
    
    Thread t2 = new Thread(r1, "thread2");
    t2.start();

}
