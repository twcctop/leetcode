package _00_题型分类._03_链表;

import entity.ListNode;
import org.junit.Test;

public class _142_环形链表2 {

  public boolean hasCycle(ListNode head) {
    if(head.next==null){
      return  false;
    }
    ListNode slow = head;
    ListNode fast= head.next;
    while(fast.next!=null){
      slow=slow.next;
      if(fast.next==null||fast.next.next==null){
        return false;
      };
      fast= fast.next.next;
      if (fast.val==slow.val){
        return true;
      }
    }
    return false;
  }


  // 环形链表2
  @Test
  public void test142(){

  }
}
