import org.junit.Test;

import javax.naming.ldap.LdapReferralException;
import java.util.*;

/**
 * @Author: twc
 * @Date 2021/1/5 11:51
 **/

public class code {
    @Test
    public void test() {
//        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] a = {0, 0, 0, 0};
//        int[] a = {-4, -1, -1, 0, 1, 2};
//        System.out.println("testCase");
        System.out.println(threeSum(a));
//        System.out.println(threeSum2(a));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            int third = nums.length - 1;
            // i去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j >= third) {
                    break;
                }
                // j 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[j] + nums[third] == 0) {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[third]);
                    res.add(list);
                } else if (nums[i] + nums[j] + nums[third] > 0) {
                    third--;
                    j--;
                }
            }
        }
        return res;
    }

    @Test
    public void testThreeSum2() {
        int[] a = {0, 0, 0, 0};
        threeSum2(a);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    @Test
    public void test206() {
        System.out.println();
        ;
        int[] a = {1, 2, 3, 4, 5};
//        Solution206  s206=new Solution206()
//        System.out.println(s206.reverseList(node));
    }

    class Solution206 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ;

        ListNode(int x) {
            val = x;
        }

        ;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test24() {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//        System.out.println(swapPairs(node1));
        System.out.println(swapPairs2(node1));

    }

    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println("test" + cur.val + "++cu+++" + cur.next.val);
            ListNode next = cur.next;
            if (next != null) {
                ListNode temp = next.next;

                next = cur;
                cur.next = temp;
//                System.out.println("test"+cur.val+"++cu+++"+cur.next.val);
                if (cur.next == null) {
                    break;
                }
                cur = cur.next;
            }
            System.out.println("---" + cur.val + "++cu+++" + cur.next.val);
        }
        return head;
    }

    // 1-> 2 3 4 5
    // 2-1-4-3-5
    public ListNode swapPairs2(ListNode head) {
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur;
            ListNode node2 = cur.next;
            ListNode node3 = cur.next.next;
            node2.next = node1;
            node1.next = node3;
            cur = node1;
            cur.next = node2;
            break;
        }
        return cur;
    }

    public ListNode swapPairs3(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    @Test
    public void test189() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        rotate(a, 3);
        System.out.println(a[3]);

    }

    public void rotate(int[] nums, int k) {

        int[] clone = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int offset = i - k;
            if (offset < 0) {
                offset = offset + nums.length;
            }
            nums[i] = clone[offset];
        }
    }

    @Test
    public void test88() {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        merge(a, 3, b, 3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsRes = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (i < m) {
                if (nums1[i] == 0) continue;
                numsRes[i] = nums1[i];

            } else {
                if (nums2[i - m] == 0) continue;
                numsRes[i] = nums2[i - m];
            }

        }
        nums1 = numsRes;
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, m, nums1, n, m + n);
        Arrays.sort(nums1);
    }

    @Test
    public void test1() {
        int[] a = {2, 5, 5, 11};

        twoSum(a, 10);

    }

    public int[] twoSum(int[] nums, int target) {
        int[] numsOri = nums.clone();
        int[] res = {-1, -1};
        int[] resOri = new int[2];
        Arrays.sort(nums);
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            System.out.println("pre" + i + "#" + j);
            if (nums[nums.length - 1] + nums[i] - target < 0) {
                System.out.println("<0" + i);
                i++;
                j = i + 1;
            }

            if (nums[j] + nums[i] - target == 0) {
                System.out.println("=0" + i);
                int[] c = {nums[i], nums[j]};
                resOri = c;

            }
        }
        for (int k = 0; k < numsOri.length; k++) {
            if (resOri[0] == numsOri[k] || resOri[1] == numsOri[k]) {
                if (res[0] == -1) {
                    res[0] = k;
                } else {
                    res[1] = k;
                    return res;
                }
            }
        }
        return res;
    }

    @Test
    public void test20() {
//        testQuene();
//        testDeque();
        String s = "()[]{}";
        isValid(s);

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
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
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
            if(len==0){
                return   0;
            }
            if(len==1){
                return nums[0];
            }
            if(len==2){
                return Math.max(nums[0],nums[1]);
            }
            int first= nums[0];
            int second  = Math.max(first,nums[1]);
            int res=0;
            for(int i=2;i<len;i++){
                int temp =second;
                res= Math.max(second,nums[i]+first);
                second=res;
                first=temp;
            }
            return res;
        }

}


