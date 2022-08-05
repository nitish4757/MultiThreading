package producerConsumer;

import java.util.Queue;

public class Producer implements Runnable{

    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue)
        {
            for(int i=0;i<10;i++)
            {
                if (queue.size() < 4) {
                    System.out.println("Inserting into queue " + i );
                    queue.add(i);
                }
                else {
                    try {
                        queue.wait();
                        System.out.println("Inserting into queue " + i );
                        queue.add(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.notifyAll();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
