package leetbook.图解算法数据结构;

import entity.Node;
import org.junit.Test;
import util.ArrayUtil;

import java.util.*;

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

    /**
     * @Description
     * @Date 2021/6/3 12:17
     **/
    @Test
    public void test59_1() {
        int[] ints = ArrayUtil.convertStringIntToArray("[1,3,-1,-3,5,3,6,7]");
        int[] ints1 = maxSlidingWindow(ints, 3);
        ArrayUtil.printIntArray(ints1);
    }
    // todo for循环 超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length==0) {
            return  new int[0];
        }
        int[] res = new  int[length+1-k];
        for (int i = 0; i <= nums.length-k; i++) {
            int max=nums[i];
            //取方块最大值
            for (int j = i; j < k+i; j++) {
                max=Math.max(max,nums[j]);
            }
            res[i]= max;
        }
        return res;
    }

    //todo 采用deque 直接删除小于添加值的元素
    public int[] maxSlidingWindowKGod(int[] nums, int k) {
        if (nums.length==0 || k==0) {
             return  new int[0];
        }
        int length = nums.length;
        if (length==0) {
            return  new int[0];
        }
        int[] res = new  int[length+1-k];

        Deque<Integer> deque = new LinkedList<>();
        for (int j = 0, i=1-k; j < nums.length; j++,i++) {
             //删除deque中对应的nums[i-1]
            if (i>0 && deque.peekFirst()== nums[i-1]) {
                deque.removeFirst();
            }
            //保持deque递减
            while(!deque.isEmpty() && deque.peekLast()<nums[j]){
                 deque.removeLast();
            }
            deque.addLast(nums[j]);
            //记录窗口最大值
            if (i>0) {
                 res[i]= deque.peekFirst();
            }

        }

        return res;
    }

    //59-2 队列的最大值   todo 队列最大值的问题一直搞不明白
    //为什么要维护两个队列
    class MaxQueue {
        Deque<Integer> A;
        Deque<Integer> B;
        public MaxQueue( ) {
            A=new LinkedList<>();
            B=new LinkedList<>();
        }

        public int max_value() {
            return    B.isEmpty()?-1:B.peek();
        }

        public void push_back(int value) {
           while(!B.isEmpty() && B.peekLast()<value){
                B.pollLast();
           }
           //todo 注意：offerlast 和push的区别
           B.offerLast(value);
           A.offerLast(value);
        }

        public int pop_front() {
            if (!A.isEmpty()&& !B.isEmpty() && A.peekFirst().equals(B.peekFirst())) {
                 B.removeFirst();
            }
            if (!A.isEmpty()) {
              return   A.removeFirst();
            }
             return  -1;
        }
    }

    //67 字符串转换为数字
    //todo 抄答案的
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length==0) {
             return 0;
        }
        int res=0, bndcry=Integer.MAX_VALUE/10;
        int i=1,sign=1;
        if (c[0]=='-') {
            sign=-1;
        }else if(c[0]!='+'){
           i=0;
        }
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndcry || res == bndcry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res  *10 + (c[j] - '0');
        }

        return  sign* res;


    }
}
