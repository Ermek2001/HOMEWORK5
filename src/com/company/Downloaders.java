package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread{
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    int b;

    public Downloaders(Semaphore semaphore, CountDownLatch countDownLatch, int b){
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        this.b = b;
    }

    @Override
    public synchronized void start(){
        try {
            for (int i = 100; i <500 ; i+=100) {
                semaphore.acquire();
                System.out.println("Идеет скачивание файла со скростью " + i + "мб");
                sleep(2000);
                semaphore.release();
                countDownLatch.countDown();

            }
        }catch (Exception e)
    }
}
