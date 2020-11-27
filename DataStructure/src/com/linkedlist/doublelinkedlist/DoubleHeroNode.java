package com.linkedlist.doublelinkedlist;

/**
 * @author Harold
 * @Date 2020/10/24
 * @Description : 水浒好汉信息，信息节点
 */
public class DoubleHeroNode {

    public int no;
    public String name;
    public String nickname;
    //后一节点
    public DoubleHeroNode next;
    //前一节点
    public DoubleHeroNode pre;

    public DoubleHeroNode() {
    }

    public DoubleHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
