package 算法训练营覃超题目;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: twc
 * @Date 2021/3/9 17:55
 **/
public class _04栈_队列_双端队列_优先队列 {


    /**
     * 堆栈
     */

    //有效的括号
    @Test
    public void test20() {
        String s = "()";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                stack.push(cur);
            } else {
                if (!stack.isEmpty() && map.get(stack.peek()).equals(cur)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 最小栈
    @Test
    public void test155() {
        MinStack obj = new MinStack();
//         obj.push(x);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

    }

    /**
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class MinStack {

        Deque<Integer> stack;
        Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(x, minStack.peek()));

            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


    @Test
    public void test84() {

    }

    //    public int largestRectangleArea(int[] heights) {
//         int n= heights.length;
//         int[] left = new int[n];
//         int[] right = new int[n];
//
//         Stack<Integer> mono_stack = new Stack<Integer>();
//
//
//
//
//
//    }

    //滑动窗口最大值
    @Test
    public void test239() {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(arr, 3));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int len = nums.length;
        if (k >= len) {
            int[] shortRes = new int[1];
            shortRes[0] = maxInt(nums);
            return shortRes;
        }

        int[] res = new int[len - k + 1];
        int slow = 0, preSlow = 0;

        int[] ori = new int[k];
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                ori[i] = nums[i];
            } else if (i == k - 1) {
                res[0] = maxInt(ori);

            } else {
                preSlow = slow;
                slow++;
//                 res[slow]=Math.max(nums[i],res[preSlow]);
                res[slow] = Math.max(maxStartToEnd(nums, i, i + k), res[preSlow]);
            }
        }

        return res;

    }

    public int maxInt(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res) {
                res = arr[i];
            }
        }
        return res;
    }

    public int maxStartToEnd(int[] source, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            if (source[i] > res) {
                res = source[i];
            }
        }
        return res;

    }


    //设计循环队列
    @Test
    public void test622() {
//        MyCircularQueue obj = new MyCircularQueue(k);
//        boolean param_1 = obj.enQueue(value);
//        boolean param_2 = obj.deQueue();
//        int param_3 = obj.Front();
//        int param_4 = obj.Rear();
//        boolean param_5 = obj.isEmpty();
//        boolean param_6 = obj.isFull();
    }

    class MyCircularQueue {
        private int[] quene;
        private int headIndex;
        private int count;
        private int capacity;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.quene = new int[k];
            this.headIndex = 0;
            this.count = 0;

        }

        public boolean enQueue(int value) {
            if (count == capacity) {
                return false;
            }
            ;
            //  起始 ,加上长度%  容量一定是当前的位置
            quene[(this.headIndex + this.count) % capacity] = value;
            count++;
            return true;
        }

        public boolean deQueue() {
            if (count == 0) {
                return false;
            }
            headIndex = (headIndex + 1) % this.capacity;
            count -= 1;
            return true;
        }

        public int Front() {
            if (count == 1) {
                return -1;
            }
            int tailInex = (headIndex + count - 1) % capacity;
            return quene[tailInex];
        }

        public int Rear() {
            if (count == 1) {
                return -1;
            }
            return quene[headIndex];

        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == capacity;
        }
    }

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     * MyCircularDeque(k)：构造函数,双端队列的大小为k。
     * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
     * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
     * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
     * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
     * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
     * isEmpty()：检查双端队列是否为空。
     * isFull()：检查双端队列是否满了。
     * 示例：
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/design-circular-deque
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
//class MyCircularDeque {
//
//    private int capacity;
//    private int count;
//    private int head;
//    private int tail;
//    private int[] quene;
//
//    /** Initialize your data structure here. Set the size of the deque to be k. */
//    public MyCircularDeque(int k) {
//        capacity=k;
//        count=0;
//        head=0;
//        tail=head+count-1;
//        quene=new int[k];
//    }
//
//    /** Adds an item at the front of Deque. Return true if the operation is successful. */
//    public boolean insertFront(int value) {
//        if (capacity>=count) {
//             return false;
//        }
//        quene[head]=
//    }
//
//    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
//    public boolean insertLast(int value) {
//
//    }
//
//    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
//    public boolean deleteFront() {
//
//    }
//
//    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//    public boolean deleteLast() {
//
//    }
//
//    /** Get thse front item from the deque. */
//    public int getFront() {
//
//    }
//
//    /** Get the last item from the deque. */
//    public int getRear() {
//
//    }
//
//    /** Checks whether the circular deque is empty or not. */
//    public boolean isEmpty() {
//
//    }
//
//    /** Checks whether the circular deque is full or not. */
//    public boolean isFull() {
//
//    }
//}

    // 设计循环双端队列
    @Test
    public void test641() {

    }


    //接雨水
    @Test
    public void test42(){


    }


}
