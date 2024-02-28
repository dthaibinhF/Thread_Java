package Excercise;

public class Consumer implements Runnable {
    private Storge storge;
    private boolean RUNNING = true;

    public Consumer(Storge storge) {
        this.storge = storge;
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void consume() throws InterruptedException {
        while (RUNNING) {
            if (this.storge.isEmpty()) {
                System.out.println("kho rong - ngung tieu thu");
                try {
                    this.storge.wait();
                } catch (InterruptedException e) {
                    Thread.sleep(1000L);
                }
            } else {
                this.storge.consume();
                Thread.sleep(1000L);
            }

        }
    }

    public void stop() {
        this.RUNNING = false;
    }
}
