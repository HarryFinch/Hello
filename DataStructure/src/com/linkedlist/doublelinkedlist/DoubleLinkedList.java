package com.linkedlist.doublelinkedlist;

/**
 * @author Harold
 * @Date 2020/11/10
 * @Description :
 */
public class DoubleLinkedList {

    private DoubleHeroNode head = new DoubleHeroNode();

    //获取头节点
    public DoubleHeroNode getHead() {
        return head;
    }

    //遍历双向链表
    public void doubleList() {
        if (head.next == null) {
            System.out.println("The doubleLinkedList is empty");
            return;
        }
        DoubleHeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //双向链表的添加，默认尾插法
    public void addByTail(DoubleHeroNode doubleHeroNode) {
        DoubleHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //将节点添加到链表的尾部
        temp.next = doubleHeroNode;
        doubleHeroNode.pre = temp;
    }

    public void addByOrder(DoubleHeroNode newHeroNode) {
        DoubleHeroNode temp = head;
        // 标志链表中是否已经存在将要添加的节点
        boolean flag = false;
        while (true) {
            //链表的最后一个节点
            if (temp.next == null) {
                break;
            }
            //寻找添加节点的位置
            if (newHeroNode.no < temp.next.no) {
                break;
            }
            //判定新节点编号是否与已存在的节点编号重复
            if (temp.next.no == newHeroNode.no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        //要添加的节点已经存在
        if (flag) {
            System.out.println("The hero`s info has existed " + newHeroNode.toString());
        } else {
            /*
             节点添加操作
             */
            newHeroNode.next = temp.next;
            temp.next = newHeroNode;
            temp.next.pre = newHeroNode;
            newHeroNode.pre = temp;
        }
    }

    //修改节点
    public void updateDouble(DoubleHeroNode doubleHeroNode) {
        if (head.next == null) {
            System.out.println("The doubleLinkedList is empty");
            return;
        }
        DoubleHeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == doubleHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = doubleHeroNode.name;
            temp.nickname = doubleHeroNode.nickname;
        } else {
            System.out.println("The element does not existed");
        }
    }

    /*
     * @Description : 删除节点，找到元素，自我删除
     * @Param : 梁山英雄排名
     * @return : void
     */
    public void delDoubleLink(int no) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("The doubleLinkedList is empty");
            return;
        }
        //定义辅助节点，遍历
        DoubleHeroNode temp = head.next;
        //标志是否找到要删除的结点
        boolean flag = false;
        //循环遍历
        while (true) {
            //遍历到链表结尾，仍未找到需要删除的结点
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //是否找到要删除节点的不同操作
        if (flag) {
            temp.pre.next = temp.next;
            //最后一个节点的next是空，最后一个节点不用执行此语句
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("The element does not existed");
        }
    }

}
