package entity;

/**
 *  链表中的节点
 */
public class ListNode {
    public ListNode next;
    public Integer val;

    public ListNode() {
    }

    ;

    public ListNode(int x) {
        val = x;
    }

    ;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}