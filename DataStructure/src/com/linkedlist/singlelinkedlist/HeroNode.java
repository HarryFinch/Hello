package com.linkedlist.singlelinkedlist;

/**
 * @author Harold
 * @Date 2020/10/24
 * @Description : 水浒好汉信息，信息节点
 */
public class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickname) {
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
