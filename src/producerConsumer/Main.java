package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Message message = new Message("hello world");
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread thread1 = new Thread(producer,"Producer Thread");
        Thread thread2 = new Thread(consumer,"Consumer Thread");
        thread1.start();
        thread2.start();

    }
}
