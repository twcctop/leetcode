package leetbook._02_初级算法;

import entity.ListNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: twc
 * @Date 2021/6/18 12:10
 **/
public class _03链表 {

    public void deleteNode(ListNode node) {
            node.val=node.next.val;
            node.next=node.next.next;
    }

    //删除链表中的倒数第n个节点

    /**
     * @Description
     * @Date 2021/6/21 11:48
     **/
    //[0,0,8,8,0,9,5,0,1,1,7,5,6,9,4,4,2,5,2]
    //14  无法通过
    @Test
    public void test() {
        //复现问题
        ListNode nod4=new ListNode(0);
        ListNode nod3=new ListNode(0,nod4);
        ListNode nod2=new ListNode(0,nod3);
        ListNode nod1=new ListNode(1,nod2);

        ListNode listNode = removeNthFromEnd(nod1, 2);
        while(listNode!=null){
            System.out.println(listNode.val);
             listNode=listNode.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
          ListNode preSlow=new ListNode(0,head);
          ListNode preFast=new ListNode(0,head);
          ListNode preHead=preSlow;
          while (n!=0){
               preFast=preFast.next;
               n--;
          }
          while (true){
              //删除节点
              if (preFast.next==null) {
                   preSlow.next=preSlow.next.next;
                    break;
              }
              preSlow=preSlow.next;
              preFast=preFast.next;
          }

          return  preHead.next;
    }

    //回文链表

    /**
     * @Description
     * @Date 2021/6/21 14:19
     **/
    @Test
    public void testIsPalindrome() {
         ListNode node= new ListNode(1);
        System.out.println(isPalindrome(node));
    }

    //todo 不能解决101的问题
    public boolean isPalindrome(ListNode head) {
        if (head.next==null) {
            return  true;
        }

        Deque<ListNode> deque=new LinkedList<>();
        while (head!=null ) {
            if (!deque.isEmpty() && deque.getLast().val==(head.val)) {
                deque.pollLast();
            }else {
             deque.addLast(head);
            }
            head=head.next;
        }
        return  deque.isEmpty();
    }
}
