package com.javarush.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by Владимир on 21.10.2017.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue = new LinkedTransferQueue<>();

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    public TransferQueue<ShareItem> getQueue() {
        return queue;
    }

    public void setQueue(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
            while (!Thread.currentThread().isInterrupted()) {
                ShareItem item = queue.take();
                System.out.format("Processing " + item.toString());
            }
        }
        catch (InterruptedException e) {
            return;
        }
    }
}
