package _00_题型分类._03_链表;

import entity.ListNode;
import java.util.Objects;
import org.junit.Test;
//  https://leetcode-cn.com/problems/swap-nodes-in-pairs/

public class _24_两两交换链表 {
  @Test
  public void test24() {
    ListNode node4 = new ListNode(4);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
//        System.out.println(swapPairs(node1));
    System.out.println(swapPairs4(node1).val);

  }

  public ListNode swapPairs(ListNode head) {
    ListNode cur = head;
    while (cur != null) {
      System.out.println("test" + cur.val + "++cu+++" + cur.next.val);
      ListNode next = cur.next;
      if (next != null) {
        ListNode temp = next.next;

        next = cur;
        cur.next = temp;
//                System.out.println("test"+cur.val+"++cu+++"+cur.next.val);
        if (cur.next == null) {
          break;
        }
        cur = cur.next;
      }
      System.out.println("---" + cur.val + "++cu+++" + cur.next.val);
    }
    return head;
  }

  // 1-> 2 3 4 5
  // 2-1-4-3-5
  public ListNode swapPairs2(ListNode head) {
    ListNode cur = head;
    while (cur.next != null && cur.next.next != null) {
      ListNode node1 = cur;
      ListNode node2 = cur.next;
      ListNode node3 = cur.next.next;
      node2.next = node1;
      node1.next = node3;
      cur = node1;
      cur.next = node2;
      break;
    }
    return cur;
  }

  public ListNode swapPairs3(ListNode head) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode temp = dummyHead;
    while (temp.next != null && temp.next.next != null) {
      ListNode node1 = temp.next;
      ListNode node2 = temp.next.next;
      temp.next = node2;
      node1.next = node2.next;
      node2.next = node1;
      temp = node1;
    }
    return dummyHead.next;
  }

  public ListNode swapPairs4(ListNode head) {
    if (head==null) {
      return null;
    }

    ListNode curr = head;
    if(Objects.nonNull(head.next)){
      head=head.next;
    }
    ListNode prev =new ListNode();

    while(curr.next!=null){
      // 记录原始数据
      ListNode third= curr.next.next;
      ListNode next = curr.next;
      //  位置交换
      prev.next=next;
      prev.next.next=curr;
      if (third==null) {
        prev.next.next.next=null;
        break;
      }

      prev.next.next.next=third;
      curr=third;
      prev=prev.next.next;
    }
    System.out.println(head.val);
    System.out.println(head.next.val);
    System.out.println(head.next.next.val);
    System.out.println(head.next.next.next.val);
    return head;
  }

}
