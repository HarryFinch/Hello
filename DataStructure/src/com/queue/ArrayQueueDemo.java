package com.queue;

import java.util.Scanner;

/**
 * @author Harold
 * @Date 2020/8/20
 * @Description : 使用数组模拟队列
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)");//显示队列
            System.out.println("e(exit)");//退出程序
            System.out.println("a(add)");//添加数据
            System.out.println("g(get)");//获取数据
            System.out.println("h(head)");//获取头数据
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.print("Input a digit : ");
                    int element = scanner.nextInt();
                    queue.addQueue(element);
                    break;
                case 'g':
                    System.out.println(queue.getQueue());
                    break;
                case 'h':
                    System.out.println(queue.getQueueFront());
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }

}

