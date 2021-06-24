package leetbook.初级算法;

import org.junit.Test;
import util.ArrayUtil;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/21 16:12
 **/
public class _07设计问题 {

    /**
     * @Description
     * @Date 2021/6/22 15:25
     **/
    @Test
    public void test() {
        int[] s={1,2,3};
        Solution sou= new Solution(s);
        ArrayUtil.printIntArray(sou.shuffle());
        ArrayUtil.printIntArray(sou.reset());
        ArrayUtil.printIntArray(sou.shuffle());


    }

    class Solution {
        int[] origin;
        int[] modified;
        List<Integer> list;
        public Solution(int[] nums) {
            origin=nums;
            modified=nums;
            list= new ArrayList<>();
            for (int num : nums) {
                 list.add( num);
            }
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return  origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            Collections.shuffle(list);
            for (int i = 0; i < modified.length; i++) {
                 modified[i]=list.get(i);
            }
            return  modified;
        }
    }

    //

    class MinStack {
        Deque<Integer> deque1 ;
        Deque<Integer> deque2 ;

        /** initialize your data structure here. */
        public MinStack() {
               deque1=new LinkedList<>();
              deque2= new LinkedList<>();
        }

        public void push(int val) {
              deque1.addLast(val);
            if (deque2.isEmpty()) {
                 deque2.addLast(val);
            }else{
                 deque2.addLast(Math.min(deque2.getLast(),val));
            }
        }

        public void pop() {
            deque2.pollLast();
            deque1.pollLast();

        }

        public int top() {
            return  deque1.getLast();

        }

        public int getMin() {
            return  deque2.getLast();
        }
    }
}
