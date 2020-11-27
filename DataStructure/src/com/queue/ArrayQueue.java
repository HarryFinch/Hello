package com.queue;

import java.awt.*;

/**
 * @author Harold
 * @Date 2020/8/20
 * @Description : 该类表示队列结构
 */
class ArrayQueue {
    private int maxSize;//表示数组最大容量
    private int front;//指向队列头的前一个位置
    private int rear;//指向队列尾部
    private int[] arr;//队列容器，用于存放数据

    //创建队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列尾部(最后一个元素的位置)，队列中还没有元素，尾部与头部重合
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
//            return;
        } else {
            arr[++rear] = element;
        }
    }

    //获取队列的数据
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            throw new RuntimeException("Queue is empty");
        } else {
            return arr[++front];
        }
    }

    //显示队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("arr[ " + i + " ]" + arr[i]);
            }
        }
    }

    //显示队列头部数据
    public int getQueueFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty...");
            throw new RuntimeException("Queue is empty...");
        }
        return arr[front + 1];
    }
}
