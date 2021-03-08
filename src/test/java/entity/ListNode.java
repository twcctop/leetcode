package entity;

public class ListNode {
    public ListNode next;
    public Integer val;

    ListNode() {
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