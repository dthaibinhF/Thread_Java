package Excercise;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;

public class Storge {
    private int maxSize;
    private Queue storge;
    
    public Storge() {
        storge = new ArrayDeque<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }


    public int size() {
        return storge.size();
    }

    public void produce(int n) {
        synchronized (this) {
            this.storge.add(n);
            System.out.println("San xuat san pham " + n);
            this.notify();
        }
    }

    public void consume() {
        synchronized (this) {
            System.out.println("Tieu thu san pham " + this.storge.poll());
            this.notify();
        }
    }

    public boolean isEmpty() {
        return this.storge.isEmpty();
    }
}
