package part3.exercise;

import part3.MyLinkedList;

public class Q2 {

    /**
     *
     * 单链表
     * 传入一个节点，交换这个节点之后的两个节点
     *
     * @param node
     */
    public void swop1(MyLinkedList.Node node) {

        MyLinkedList.Node tmp = node.next;
        node.next = tmp.next;
        tmp.next = tmp.next.next;
        node.next.next = tmp;
    }

    /**
     *
     * 双向链表
     * 传入一个节点，交换这个节点与之后的一个节点
     *
     * @param node
     */
    public void swop2(MyLinkedList.Node node) {

        MyLinkedList.Node tmp = node.next;
        node.next = tmp.next;
        tmp.prev = node.prev;
        node.prev = tmp;
        tmp.next = node;
    }
}
