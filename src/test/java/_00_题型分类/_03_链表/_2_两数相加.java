package _00_题型分类._03_链表;

import entity.ListNode;
import org.junit.Test;
import util.NodeUtil;

public class _2_两数相加 {


//  https://leetcode-cn.com/problems/add-two-numbers/

  @Test
  public void test2() {
    ListNode l13 = new ListNode(3);
    ListNode l14 = new ListNode(4,l13);
    ListNode l12 = new ListNode(2,l14);

    ListNode l24 = new ListNode(4);
    ListNode l26 = new ListNode(6,l24);
    ListNode l25 = new ListNode(5,l26);

    NodeUtil.printNode(addTwoNumbers(l12,l25));

  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node=new ListNode();
    ListNode head=node;
    int  addNum=0;
    int  val=0;
    while(l1!=null ||  l2!=null || addNum==1){
      if (l1!=null && l2!=null) {
        val=l1.val+l2.val+addNum;
        addNum=0;
        if (val>=10) {
          addNum++;
          val=val-10;
        }
      }
      //
      if (l1==null && l2!=null) {
        val=l2.val+addNum;
        addNum=0;
        if (val>=10) {
          addNum++;
          val=val-10;
        }
      }
      //
      if (l1!=null && l2==null) {
        val=l1.val+addNum;
        addNum=0;
        if (val>=10) {
          addNum++;
          val=val-10;
        }
      }
      if (l1==null && l2==null && addNum==1) {
        val=addNum;
        addNum=0;
      }

      //处理值
      node.val=val;


      if( (l1!=null&&l1.next!=null) || (l2!=null&& l2.next!=null)|| addNum==1){
        ListNode next=new ListNode();
        node.next=next;
        node=next;
      }
      if (l1!=null) {
        l1=l1.next;
      }
      if (l2!=null) {
        l2=l2.next;
      }

    }
    return head;
  }


}
