package com.linkedlist.singlelinkedlist;

import java.util.Stack;

/**
 * @author Harold
 * @Date 2020/10/25
 * @Description :
 */
public class LinkedListInterview {

    /*
     * @Description : 获取链表节点个数
     * @Param : 链表的第一个节点或者头节点
     * @return : 链表节点的个数
     */
    public int getLength(HeroNode head) {
        if (head.next == null) {
            System.out.println("The linked list is empty");
            return -1;
        }
        int nodeLength = 0;
        // 忽略头节点
        HeroNode temp = head.next;
        while (temp != null) {
            nodeLength++;
            temp = temp.next;
        }
        return nodeLength;
    }

    /* 新浪面试
     * @Description : 查找链表倒数第K个节点
     * 思路
     * 1、编写一个方法，接收 head 节点，同时接收一个 index(表示倒数第几个节点)
     * 2、先把链表从头到尾遍历，得到链表的总长度(length)
     * 3、从链表的第一个开始遍历，遍历(length - index)次，这样就可以找到目标节点
     * 4、如果找到，返回该节点，否则返回空
     * @Param : head 链表头结点
     * @Param : index 链表倒数第几个节点
     * @return : 目标节点或者null
     */
    public HeroNode findNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        //获取链表总长度
        int nodeLength = getLength(head);
        //数据校验
        if (index <= 0 || index > nodeLength) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < nodeLength - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /* 腾讯面试
     * @Description : 链表反转
     *  1、定义一个节点，reverseHead = new HeroNode();
     *  2、从头遍历原来的链表，每遍历一个节点，就将其取出，并放在新链表的最前端(头插法)
     *  3、原来的链表，head.next = reverseHead.next;
     *      将原头节点，连接到新节点的尾部
     * @Param : 原链表的头节点
     * @return : 新链表的头节点
     */
    public HeroNode reverseNode(HeroNode head) {
        HeroNode reverseHead = new HeroNode();
        if (head.next == null || head.next.next == null) {
            return null;
        }
        HeroNode temp = head.next;
        HeroNode next = temp;
        while (true) {
            if (temp == null) {
                break;
            }
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
            head.next = temp;
        }
        head.next = reverseHead.next;
        return head;
    }

    /*
     * @Description : 使用栈的方式，实现逆序打印链表
     *                 链表本身没有发生变化，节点顺序与创建时无异
     * @Param : 链表头节点
     * @return : void
     */
    public void reverseNodeByStack(HeroNode heroNode) {
        //空链表
        if (heroNode.next == null) {
            return;
        }
        //创建一个栈，将链表节点压入栈中
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = heroNode.next;
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }
        while (heroNodes.size() > 0) {
            System.out.println(heroNodes.pop());
        }
    }

}
