package _00_题型分类._03_链表;

import entity.ListNode;
import org.junit.Test;
//https://leetcode-cn.com/problems/linked-list-cycle-ii/

//https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=295&tqId=23449&ru=%2Fpractice%2F253d2c59ec3e4bc68da16833f79a38e4&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295

/**
 *  判断链表的入口节点
 *
 */
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
