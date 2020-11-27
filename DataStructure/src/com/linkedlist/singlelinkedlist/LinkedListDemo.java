package com.linkedlist.singlelinkedlist;

/**
 * @author Harold
 * @Date 2020/10/24
 * @Description : 链表
 * 1、链表是以结点的方式存储
 * 2、每个结点包含 data 域 和 next 域，
 *    data 域存储数据，next 域指向下一节点
 * 3、链表的结点不一定是连续存储
 * 4、链表分为带头结点的和没有头结点两种，根据实际需求选择
 *
 * 头节点不存放具体数据，作用是表示单链表头节点
 *
 * 5、链表添加（创建）过程
 *  ① 先创建一个head头节点，作用是表示单链表的头
 *  ② 后面每添加一个头节点，就直接加入到链表的最后
 *
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        LinkedListInterview lli = new LinkedListInterview();
//        sll.addNode(new HeroNode(1, "宋江", "及时雨"));
//        sll.addNode(new HeroNode(2, "卢俊义", "玉麒麟"));
//        sll.addNode(new HeroNode(3, "无用", "智多星"));
//        sll.showList();

        sll.addNodeByOrder(new HeroNode(1, "宋江", "及时雨"));
        sll.addNodeByOrder(new HeroNode(4, "花荣", "小李广"));
        sll.addNodeByOrder(new HeroNode(3, "吴用", "智多星"));
        sll.addNodeByOrder(new HeroNode(2, "卢俊义", "玉麒麟"));
        sll.showList();
//        System.out.println(lli.getLength(sll.getHead()));
//        System.out.println(lli.findNode(sll.getHead(), 2));
        // 新建临时头节点方式，反转链表
//        lli.reverseNode(sll.getHead());
        // 通过栈反转链表
        lli.reverseNodeByStack(sll.getHead());
//        sll.showList();
        System.out.println();

//        sll.updateHeroInfo(new HeroNode(2,"小卢", "玉麒麟~"));
//        sll.showList();
//        System.out.println();
//
//        sll.deleteNode(1);
//        sll.deleteNode(2);
//        sll.deleteNode(3);
//        sll.deleteNode(4);
//        sll.showList();

    }

}
