package Excercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storge storge = new Storge();
        int sizeStorge;
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap suc chua khoa hang: ");
        sizeStorge = sc.nextInt();
        storge.setMaxSize(sizeStorge);

        Producer producer = new Producer(storge);
        Thread producerThread = new Thread(producer);

        Consumer consumer = new Consumer(storge);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();


    }
}
