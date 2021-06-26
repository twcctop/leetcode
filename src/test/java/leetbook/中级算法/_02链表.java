package leetbook.中级算法;

import entity.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @Author: twc
 * @Date 2021/6/26 11:47
 **/
public class _02链表 {

    //两数相加  模拟
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    /**
     * @Description
     * @Date 2021/6/26 15:18
     **/
    @Test
    public void testOddEvenList() {

        ListNode node2=new ListNode(2);
        ListNode node1=new ListNode(1,node2);
        oddEvenList(node1);
    }

    //奇偶链表
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) {
          return head;
        }
          ListNode singleNode= head;
          ListNode singleNodeHead= singleNode;
          ListNode doubleNode = singleNode.next;
          ListNode doubleNodeHead = doubleNode;

          while (singleNode!=null && doubleNode!=null){
              if (doubleNode.next==null) {
                   break;
              }
              singleNode.next = doubleNode.next;
              singleNode = doubleNode.next;
              doubleNode.next = singleNode.next;
              doubleNode = singleNode.next;

          }
          singleNode.next= doubleNodeHead;

          return head;

    }

}
