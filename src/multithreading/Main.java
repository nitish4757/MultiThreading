package multithreading;

public class Main {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("processing started called by " + Thread.currentThread().getName());
        Main m1 = new Main();
        m1.testWaitAndNotifyConcepts();
   //     m1.testWithoutNotifyConcepts();
    }

    public void testWithoutNotifyConcepts()
    {
       OperationWithoutNotify operationWithoutNotify = new OperationWithoutNotify();
       Thread thread = new Thread(operationWithoutNotify,"WithoutNotifyThread");
       thread.start();
    }

    public void testWaitAndNotifyConcepts() throws InterruptedException {
        Operation1 operation1 = new Operation1(this);
  //      Operation1 operation1Second = new Operation1(this);
        Operation2 operation2 = new Operation2(this);
        Thread t1 = new Thread(operation1,"t1");
  //      Thread t3 = new Thread(operation1Second,"t3");
        Thread t2 = new Thread(operation2,"t2");
        t1.start();
 //       t3.start();
        t2.start();
        t1.join();
        System.out.println("processing ended by " + Thread.currentThread().getName());

    }

}
