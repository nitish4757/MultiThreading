package method;

public class OperationWithoutNotify implements Runnable{


    @Override
    public void run() {

        try {
            synchronized (this) {
                this.wait();
                System.out.println("Operation Without Notify is running");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
