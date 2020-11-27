package com.linkedlist.doublelinkedlist;

/**
 * @author Harold
 * @Date 2020/11/10
 * @Description :
 */
public class DoubleLinkedListDemo {

    private static DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

    public static void main(String[] args) {

//        addHero();
        addHeroByOrder();
//        System.out.println();
//        updateHeroNode();
//        System.out.println();
//        delHeroNode();

    }

    public static void addHero() {
        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "无用", "智多星");
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "林冲", "豹子头");

        doubleLinkedList.addByTail(heroNode1);
        doubleLinkedList.addByTail(heroNode2);
        doubleLinkedList.addByTail(heroNode3);
        doubleLinkedList.addByTail(heroNode4);
        doubleLinkedList.doubleList();
        System.out.println();
    }

    public static void addHeroByOrder() {

        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "无用", "智多星");
        DoubleHeroNode heroNodet = new DoubleHeroNode(3, "无用", "智多星");
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "林冲", "豹子头");

        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode3);
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.addByOrder(heroNodet);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.doubleList();
        System.out.println();
    }

    public static void updateHeroNode() {
        DoubleHeroNode wuYong = new DoubleHeroNode(3, "吴用", "智多星");
        doubleLinkedList.updateDouble(wuYong);
        doubleLinkedList.doubleList();
    }

    public static void delHeroNode() {
        doubleLinkedList.delDoubleLink(4);
        doubleLinkedList.doubleList();
    }

}
