package _00_题型分类._03_链表;

import entity.ListNode;
import org.junit.Test;
//https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=295&tqId=23267&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295
public class _合并链表 {

  /**
   * @Description
   * @Date 2022/3/27 20:10
   **/
  @Test
  public void test() {
    ListNode l5 =  new ListNode(5);
    ListNode l3 =  new ListNode(3,l5);
    ListNode l1 =  new ListNode(1,l3);
    ListNode l6 =  new ListNode(6);
    ListNode l4 =  new ListNode(4,l6);
    ListNode l2 =  new ListNode(2,l4);
    ListNode merge = Merge(l1, l2);
    while(merge!=null) {
      System.out.println(merge.val);
      merge = merge.next;
    }
  }

  ListNode dummyHead =  new ListNode(0);
  ListNode cur = dummyHead;


  public ListNode Merge(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      return  dummyHead.next;
    }

    if (list1 != null && list2 == null) {
      mergeNode(list1);
    }
    if (list1 == null && list2 != null) {
      mergeNode(list2);
    }
    if (list1 != null && list2 == null) {
      Integer  var1 = list1.val;
      Integer  var2 = list2.val;
      if(var1<var2){
        mergeNode(list1);
      } else{
        mergeNode(list2);
      }
    }
    return  Merge(list1,list2);
  };

  public void  mergeNode(ListNode listNode) {
    dummyHead.next =   listNode.next;
    listNode = listNode.next;
  }
}
