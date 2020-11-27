package com.linkedlist.singlelinkedlist;

import java.util.Stack;

/**
 * @author Harold
 * @Date 2020/11/5
 * @Description : 演示栈的基本使用
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("Harold");
        stack.add("Tom");
        stack.add("Reese");
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

}
