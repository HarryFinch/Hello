package com.linkedlist.singlelinkedlist;

/**
 * @author Harold
 * @Date 2020/10/24
 * @Description :
 */
public class SingleLinkedList {

    //初始化一个头节点
    private HeroNode head = new HeroNode(0, "", "");

    /*
     * @Description : 添加节点到单向链表
     * @Param : heroNode 将要添加的节点
     * @return : void
     *  首先找到当前链表的最后节点
     *  将最后这个节点的 next 指向新节点
     */
    public void addNode(HeroNode heroNode) {

        // head 节点不能动，因此需要要辅助遍历
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //当temp.next值为空的时候，表示链表结束
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出了while循环，temp指向了链表最后,可以执行 添加操作了
        temp.next = heroNode;
    }

    public void addNodeByOrder(HeroNode heroNode) {
        // temp 指向的节点是即将插入节点的前一个节点
        HeroNode temp = head;
        //标志添加的编号是否存在，默认是false
        boolean flag = false;
        while (true) {
            //此时 temp 指向链表最后一个节点
            if (temp.next == null) {
                break;
            }
            //找到添加的位置
            if (temp.next.no > heroNode.no) {
                break;
            }
            //想要添加的节点已经存在
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            //后移遍历
            temp = temp.next;
        }
        if (flag) {
            System.out.println("The hero is already existed " + heroNode.toString());
        } else {
            //插入节点
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /*
     * @Description : 根据编号修改英雄任务新信息
     * @Param : 英雄节点
     * @return : void
     */
    public void updateHeroInfo(HeroNode newHeroNode) {
        HeroNode temp = head;
        boolean flag = false;

        if (temp.next == null) {
            System.out.println("The linked list is empty");
            return;
        }

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("The hero that heroNo is " + newHeroNode.no + " is not existed");
        }
    }

    /*
     * @Description : 删除英雄节点，被删除节点会被垃圾回收机制回收
     * @Param : 将要被删除的英雄编号
     * @return :
     */
    public void deleteNode(int delHeroNo) {
        HeroNode temp = head;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("The linked list is empty");
            return;
        }

        while (true) {
            //判断是否已经循环到链表的尾部
            if (temp.next == null) {
                break;
            }

            //判断当前节点的下一节点是否位将要删除的节点
            if (temp.next.no == delHeroNo) {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        //进行删除操作或者提示未找到
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("The hero node is not found");
        }

    }

    /*
     * @Description : 显示链表
     * @Param :
     * @return :
     */
    public void showList() {
        if (head.next == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        //还是因为头节点不能移动，所以需要临时变量
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }
}
