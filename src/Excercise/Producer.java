package Excercise;

import java.util.ArrayDeque;
import java.util.Queue;

public class Producer implements Runnable {
    private Storge storge;
    private boolean RUNNING = true;
    private int countProduct = 0;

    public Producer(Storge storge) {
        this.storge = storge;
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void produce() throws InterruptedException {
        while (RUNNING) {
            if (this.storge.size() == this.storge.getMaxSize()) {
                System.out.println("Kho day - ngung san xuat");
                try {
                    this.storge.wait();
                } catch (Exception e) {
                    Thread.sleep(1000L);
                }
            } else {
                this.storge.produce(++countProduct);
                Thread.sleep(1000L);
            }

        }
    }

    public void stop() {
        this.RUNNING = false;
    }
}
