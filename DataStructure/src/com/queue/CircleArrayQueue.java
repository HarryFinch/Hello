package com.queue;

/**
 * @author Harold
 * @Date 2020/10/22
 * @Description :
 */
public class CircleArrayQueue {
    private int maxSize;//表示数组最大容量
    private int front;//指向队列头的位置
    private int rear;//指向队列尾部的后一个位置
    private int[] arr;//队列容器，用于存放数据

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int ele) {
        if (isFull()) {
            System.out.println("The queue is full");
        }
        arr[rear] = ele;
        rear = (rear + 1) % maxSize;
    }

    public int getQueueEle() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        /*
         * 1、front 指向队列的第一个元素
         * 2、先把front对应的值保留到一个临时变量中
         * 3、将front后移
         * 4、返回临时变量
         */
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
        }
        //表示队列元素真实的个数
        int eleCount = front + (rear + maxSize - front) % maxSize;
        for (int i = front; i < eleCount; i++) {
            System.out.println("Queue [ " + i % maxSize + " ] : " + arr[i % maxSize]);
        }
    }

    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        return arr[front];
    }

}
