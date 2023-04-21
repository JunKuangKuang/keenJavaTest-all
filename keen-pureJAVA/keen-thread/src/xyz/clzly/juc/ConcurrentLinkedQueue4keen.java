package xyz.clzly.juc;

import java.util.concurrent.ConcurrentLinkedQueue;

/*
* 线程安全的队列
* */
public class ConcurrentLinkedQueue4keen {
    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.offer("哈哈哈");
        System.out.println("offer后，队列是否空？" + queue.isEmpty());
        System.out.println("从队列中poll：" + queue.poll());
        System.out.println("pool后，队列是否空？" + queue.isEmpty());
    }
}