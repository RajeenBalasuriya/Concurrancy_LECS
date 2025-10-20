package JavaMemoryModel;

public class MyRunnableObj implements Runnable {
    int count =0;

    MyObject obj = null;

    public MyRunnableObj(MyObject obj) {
        this.obj = obj;
    }

    @Override
    public void run(){
        System.out.println(obj +"this is obj name");
        for(int i=0;i<1000;i++){
            count++;
        }
    }


}
