package leetcode;

/*
24. 两两交换链表中的节点

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
* */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Q24 {
    // 1, 2, 3, 4, 5, 6
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Q24 q = new Q24();
        head = q.swapPairs(head);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}
