package _00_题型分类._03_链表;

import entity.ListNode;
import org.junit.Test;

public class _206_反转链表 {

  /**
   *  链表部分
   */

  @Test
  public void test206() {
    System.out.println();
    ;
    int[] a = {1, 2, 3, 4, 5};
//        reverseList(a)
//        Solution206  s206=new Solution206()
//        System.out.println(s206.reverseList(node));
  }
  // 反转链表
  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    return pre;
  }

}
