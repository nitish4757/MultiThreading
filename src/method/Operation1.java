package method;

public class Operation1 implements Runnable {
    public Main main;

    private static int counter=0;

    public Operation1(Main main) {
        this.main = main;
    }

    public static synchronized void display() throws InterruptedException {
        counter++;
        if (Thread.currentThread().getName().equals("t1")) {
            Thread.currentThread().sleep(10000);
        }
        System.out.println(Thread.currentThread().getName() + " " + counter);
    }

    public  void printOdd() throws InterruptedException {
        synchronized (main) {
            for (int i = 0; i < 20; i++) {

                if (main.getCounter() % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + " " + main.getCounter());
                    main.setCounter(main.getCounter() + 1);
                    main.notifyAll();
                }
                main.wait();
            }
        }
    }


    @Override
    public void run() {
        synchronized (this) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {
  //              this.display();
                this.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
