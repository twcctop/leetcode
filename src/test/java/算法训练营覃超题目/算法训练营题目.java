package 算法训练营覃超题目;

import entity.ListNode;
import org.junit.Test;

import javax.naming.ldap.LdapReferralException;
import java.util.*;

/**
 * @Author: twc
 * @Date 2021/1/5 11:51
 **/

public class 算法训练营题目 {

    /**
     *  堆栈
     */

    //有效的括号
    @Test
    public void test20() {
//        testQuene();
//        testDeque();
        String s = "()[]{}";
        isValid(s);
    }

    public boolean isValid2(String s) {
        return true;
    }










    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
//                stack为空

                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }

                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }



    public void testQuene() {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        System.out.println(queue);

        /**
         * one
         * [two, three]
         */
        String polledElement = queue.poll();
        System.out.println(polledElement);
        System.out.println(queue);

        System.out.println("############");

        String peekedElement = queue.peek();
        /**
         * two
         * [two, three]
         */
        System.out.println(peekedElement);
        System.out.println(queue);
        System.out.println("############");

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
        System.out.println("############");
    }

    public void testDeque() {
        Deque<String> deque = new LinkedList<String>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }



    @Test
    public void test155() {
        MinStack obj = new MinStack();
//         obj.push(x);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

    }

    class MinStack {

        Deque<Integer> xStack;
        Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }


        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
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
//    /** Get the front item from the deque. */
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
    @Test
    public void test242() {
        System.out.println(isAnagram("anagram",
                "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //
    @Test
    public void test49() {
        String[] args = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(args));
        ;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.containsKey(s)) {
                List<String> strings = map.get(s);
                strings.add(str);
                map.put(s, strings);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(s, list);
            }
        }

        List<List<String>> res = new LinkedList<List<String>>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            res.add(value);

        }
        return res;
    }


    @Test
    public void test94() {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void test322() {

    }

    //    public int coinChange(int[] coins, int amount) {
//
//    }
    @Test
    public void test69() {
//        System.out.println(mySqrt(17));
        System.out.println(mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        Long head = 0l;
        Long tail = Long.valueOf(x);
        Long res = (head + tail) / 2;
        while (true) {
            if (res * res > x) {
                tail = (head + tail) / 2;
            } else if (res * res < x) {
                head = (head + tail) / 2;
            } else if (res * res == x) {
                return res.intValue();
            }

            if (res == (head + tail) / 2) {
                return res.intValue();
            } else {
                res = (head + tail) / 2;
            }

        }
    }

    @Test
    public void test367() {

    }

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        Long head = 0l;
        Long tail = Long.valueOf(num);
        Long res = (head + tail) / 2;
        while (true) {
            if (res * res > num) {
                tail = (head + tail) / 2;
            } else if (res * res < num) {
                head = (head + tail) / 2;
            } else if (res * res == num) {
//                return  res.intValue();
                return true;
            }

            if ((tail - head == 1) && head * head != num && tail * tail != num) {
                return false;
            } else if (res * res == num) {
                return true;
            } else {
                res = (head + tail) / 2;
            }
        }

    }

    @Test
    public void test191() {
        //   idea debug得知  读取成8进制的，很怪异
        System.out.println(hammingWeight(00000000000000000000000000001011));
//        System.out.println(hammingWeight(1011));
//        System.out.println(hammingWeight(00000000000000000000000000000010));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {int count = 0;
        for
         (int i = 0; i < 32; i++) {
            int a = n >> i;
            int b = a & 1;
            if (b == 1) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test50() {
//         System.out.println(quickMul(2.0, -2147483648));
        System.out.println(myPow(2.0, -2147483648));
        System.out.println(myPow(2.0, -4));

    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);

    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
//        if(N<0) {
//            x=1/x;
//            N=-N;
//        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    @Test
    public void test78(){
      // 测试移位运算符
        System.out.println(1 << 4);
        int[] a={2,5,9};
        System.out.println(subsets(a));
    }
    List<Integer>  t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        for (int mask = 0; mask < 1<<n; mask++) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
         return  ans;
    }
     @Test
    public void test198(){
          int[] arr= {2,7,9,3,1};
         System.out.println(rob(arr));

     }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(first, nums[1]);
        int res = 0;
        for (int i = 2; i < len; i++) {
            int temp = second;
            res = Math.max(second, nums[i] + first);
            second = res;
            first = temp;
        }
        return res;
    }
    @Test
    public void  test121(){
        int[] arr= {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        if (prices.length==1) {
            return 1;
        }
        // int[i][是否持股]
        int[][] dp = new int[prices.length][2];
        dp[0][0]= 0;
        dp[0][1]= -prices[1];
        for (int i = 1; i < prices.length; i++) {
            // 不持股
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            // 持股
            dp[i][1] = dp[i-1][0]+prices[i];

        }
       return 0;
    }
    @Test
    public  void test208(){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
    }

    class Trie {
         private  boolean is_string =false;
         private  Trie next[] =new Trie[26];


        //R links to node children



        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root = this;
            char w[] = word.toCharArray();
            for (int i = 0; i < w.length; i++) {
//                  if(root.next[w[i]-'a']==null)
                if (root.next[w[i]-'a'] == null) {
                    root.next[w[i]-'a'] = new Trie();
                }
                    root = root.next[w[i]-'a'];

            }

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
          return  false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return  false;
        }
    }

    @Test
    public void test22(){

    }
    public List<String> generateParenthesis(int n) {
        return null;
    }


}



