package JavaMemoryModel;

public class Main {
    public static void main(String[] args) {
        //my runnable without object sharing
//        MyRunnable mR1=new MyRunnable();
//        MyRunnable mR2=new MyRunnable();
//
//        Thread t1=new Thread(mR1);
//        Thread t2=new Thread(mR2);
//
//        t1.start();
//        t2.start();

//object sharing part :{myobject,myrunnableobj}
        MyObject obj = new MyObject();

        MyRunnableObj mrO1 = new MyRunnableObj(obj);
        MyRunnableObj mrO2 = new MyRunnableObj(obj);

        Thread t1 = new Thread(mrO1);
        Thread t2 = new Thread(mrO2);

        t1.start();
        t2.start();



    }
}
