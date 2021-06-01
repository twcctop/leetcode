package util;

import entity.ListNode;

/**
 * @Author: twc
 * @Date 2021/6/1 15:18
 **/
public class NodeUtil {

    public  static void printNode(ListNode head){
        System.out.println(head.val);
        while (head.next!=null){
            head=head.next;
            System.out.println(head.val);
        }

    }
}
