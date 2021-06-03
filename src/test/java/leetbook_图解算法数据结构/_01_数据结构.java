package leetbook_图解算法数据结构;

import entity.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: twc
 * @Date 2021/6/2 16:29
 **/
public class _01_数据结构 {

    //09 两个栈实现队列  todo
    class CQueue {
        LinkedList<Integer> A;
        LinkedList<Integer> B;

        public CQueue() {
            A= new LinkedList<Integer>();
            B= new LinkedList<>();
        }

        public void appendTail(int value) {
             A.add(value);
        }

        public int deleteHead() {
            if(!B.isEmpty()){
             return   B.remove();
            }
            if (A.isEmpty()) {
                 return  -1;
            }
            while (!A.isEmpty()){
                  B.add(A.remove());
            }
            return  B.remove();

        }
    }

    //20  状态机
    public boolean isNumber(String s) {
        return false;
    }

    //30 todo 包含min()函数的栈 ，删除的时候不理解，为什么是 辅助栈删除
    //todo  不是自己写出来的
    class MinStack {
         Stack<Integer> A;
         Stack<Integer> B;
        /** initialize your data structure here. */
        public MinStack() {
            A= new Stack<>();
            B= new Stack<>();
        }

        public void push(int x) {
             A.push(x);
            if (B.empty()||B.peek()>= x) {
                 B.push(x);
            }
        }

        public void pop() {
            if (A.peek().equals(B.peek())) {
                B.pop();
            }
            A.pop();
        }

        public int top() {

            return  A.peek();

        }

        public int min() {
            return B.peek();
        }
    }

    //35 todo 复杂链表的复制
    public Node copyRandomList(Node head) {
         Node cur = head;
         Node copyHead = cur;
         Node copyCur = copyHead;
        //复制next
         while (cur!=null){
             if (copyCur==null) {
                  copyCur = new Node();
             }
             copyCur.val = cur.val;
             cur =cur.next;
             copyCur= copyCur.next;
         }

         //复制random   todo 链表中的值可以重复，无法确认节点的值
         cur=head;
         copyCur=copyHead;

        while(cur!=null) {

        }
        return null;
    }

    public Node copyRandomListKGod(Node head) {
         Map<Node,Node> map =new HashMap<>();
         Node cur =head;
         //第一次遍历，复制 值 没有复制关系
         while(cur!=null){
             map.put(cur,new Node(cur.val));
             cur= cur.next;
         }
         //第二遍遍历，建立关联
         cur= head;
         while(cur!=null){
             Node node = map.get(cur);
             node.next= map.get(cur.next);
             node.random= map.get(cur.random);
             cur=cur.next;
         }

         return map.get(head);
    }

    //58-2  右旋转字符串
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        if (length==0) {
            return "";
        }
        if (n==0) {
             return  s;
        }
        n= n % length;
        String substring = s.substring(0, n);
        String substring2 = s.substring(n, length);
        return substring2+substring;

    }


    //59-1 滑动窗口的最大值  todo 值都是0
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length==0) {
            return  new int[0];
        }
        int[] res = new  int[length+1-k];
        for (int i = 0; i < nums.length-k; i++) {
            int max=nums[i];
            //取方块最大值
            for (int j = i; j < k+i; j++) {
                max=Math.max(max,nums[j]);
            }
            nums[i]= max;
        }
        return res;

    }
}
