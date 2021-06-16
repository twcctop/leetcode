package leetbook.图解算法数据结构;

import entity.ListNode;
import org.junit.Test;
import util.ArrayUtil;

import java.util.Arrays;

/**
 * @Author: twc
 * @Date 2021/6/16 15:12
 **/
public class _07双指针 {


    //删除链表中的节点
    public ListNode deleteNode(ListNode head, int val) {

        ListNode cur= new ListNode();
        cur.next=head;
        ListNode curRes=cur;
        while(cur.next!=null){
            if (cur.next.val ==val) {
                 cur.next=cur.next.next;
                 break;
            }else {
                cur= cur.next;
            }
        }
        return curRes.next;

    }

    // 调整数组顺序
    class Solution21 {
        public int[] exchange(int[] nums) {
            return  new int[1];
        }
    }

    //翻转单词顺序

    /**
     * @Description
     * @Date 2021/6/16 16:43
     **/
    @Test
    public void test58() {
        System.out.println(reverseWords("a good  example"));
    }
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder sb= new StringBuilder();
        for (int i =  s1.length-1; i>=0; i--) {
            if (s1[i].equals(" ")||s1[i].equals("")) {
                 continue;
            }
             sb.append(s1[i]).append(" ");
        }
        return  sb.toString().trim();
    }


}
