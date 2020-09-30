package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {
    Semaphore semaphore;
    CountDownLatch countDownLatch;

    public Uploader(Semaphore semaphore, CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
    }

    @Override
    public synchronized void  start(){
        try {
            semaphore.acquire();
            sleep(1000);
            semaphore.release();
            countDownLatch.countDown();
        }catch (Exception e);

    }
}
