package method;

public class Operation2 implements Runnable {
    public Main main;

    public Operation2(Main main) {
        this.main = main;
    }

    public synchronized void display()
    {
        System.out.println(Thread.currentThread().getName());
    }

    public  void printEven() throws InterruptedException {
        // We are locking
        synchronized (main) {
            for (int i = 0; i < 20; i++) {
                if (main.getCounter() % 2 == 0) {
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
            try {
  //              Thread.sleep(10);
  //              this.display();
                  this.printEven();
       //         this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }

    }
}
