package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws Exception {

        Semaphore semaphore = new Semaphore(1);
        CountDownLatch countDownLatch = new CountDownLatch(500);
        System.out.println("Идет закачка файла на сервер");
        for (int i = 0; i <= 500 ; i+= 100) {

            new Uploader(semaphore, countDownLatch).start();
            System.out.println("Загружено " + i);

        }
        System.out.println("Файл загружен");

        Semaphore semaphore1 = new Semaphore(10);
        CountDownLatch countDownLatch1 = new CountDownLatch(100);
        for (int i = 0; i <=10 ; i+=3) {
            new Dowloaders(semaphore1, countDownLatch1,i).start();

            System.out.println("Скачали файл" + i + "людей");

        }
        System.out.println("Удаление файла с сервера");
        Thread.sleep(5000);
        System.out.println("Файл удален");


    }

}
