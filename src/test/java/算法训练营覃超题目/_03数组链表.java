package 算法训练营覃超题目;

import entity.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/3/9 16:44
 **/
public class _03数组链表 {


    /**
     *  1. 数组链表，跳表
     */

    //盛水最多的容器
    @Test
    public void test11(){

    }

    public int maxArea(int[] height) {
        int res=0;
        int right = height.length-1;
        int left =0;
        while(left<right){
            res=Math.max(res,(right-left)*Math.min(height[right],height[left]));
            if ( height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return res;
    }

    //移动零
    @Test
    public void test283(){

    }
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow= 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] !=0) {
                nums[slow]=nums[fast];
                slow++;
            }
        }
        for(int j =slow;j<len;j++){
            nums[j]=0;
        }

    }


    /**
     * @Description
     * @Date 2021/10/1 18:16
     **/
    @Test
    public void test() {
        System.out.println(climbStairs(5));
    }


    //爬楼梯 test70  _00_题型分类.动态规划
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

        // 三数之和 ，暴力法不推荐
    @Test
    public void test15() {
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
                    List<Integer> list = new LinkedList<>();
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
    public void test15_3(){
        int[] nums={-2,0,1,1,2};
        System.out.println(threeSum3(nums));
    }


    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res =new LinkedList<List<Integer>>();
        List<String> deduplcationList = new LinkedList<String>();
        int len = nums.length;
        Arrays.sort(nums);
        int k = len - 1;
        int j = 1;
        nums[-1]= 1;
        for (int i = 0; i <k; i++) {
            //去重
            if (nums[i]>0 || nums[i]==nums[i-1] ) {
                continue;
            }
            for(j=i+1;j<k;j++ ){
                //边界条件
                if (nums[i]+ nums[k-1]+ nums[k]<0) {
                    continue;
                }
                if(nums[i]+nums[i+1]+nums[k]>0){
                    k--;
                    i--;
                    continue;
                }
                if (nums[i]+ nums[j]+ nums[k]==0) {
                    List<Integer>  list = new LinkedList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    String  duplicateFlag=  nums[i]+"-"+nums[j]+"-"+nums[k];
                    // 去重
                    if (!deduplcationList.contains(duplicateFlag)) {
                        res.add(list);
                        deduplcationList.add(duplicateFlag);
                    }
                }
            }
        }
        //去重 【0,0,0,0] => [0,0,0}

        return res;

    }


    /**
     *  链表部分
     */

    @Test
    public void test206() {
        System.out.println();
        ;
        int[] a = {1, 2, 3, 4, 5};
//        reverseList(a)
//        Solution206  s206=new Solution206()
//        System.out.println(s206.reverseList(node));
    }
    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }



    @Test
    public void test24() {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//        System.out.println(swapPairs(node1));
        System.out.println(swapPairs4(node1).val);

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

    public ListNode swapPairs4(ListNode head) {
        if (head==null) {
            return null;
        }

        ListNode curr = head;
        if(Objects.nonNull(head.next)){
            head=head.next;
        }
        ListNode prev =new ListNode();

        while(curr.next!=null){
            // 记录原始数据
            ListNode third= curr.next.next;
            ListNode next = curr.next;
            //  位置交换
            prev.next=next;
            prev.next.next=curr;
            if (third==null) {
                prev.next.next.next=null;
                break;
            }

            prev.next.next.next=third;
            curr=third;
            prev=prev.next.next;
        }
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
        return head;
    }

   @Test
   public void test141(){

   }
   public boolean hasCycle(ListNode head) {
        if(head.next==null){
              return  false;
        }
        ListNode slow = head;
        ListNode fast= head.next;
        while(fast.next!=null){
              slow=slow.next;
              if(fast.next==null||fast.next.next==null){
                  return false;
              };
              fast= fast.next.next;
              if (fast.val==slow.val){
                   return true;
              }
        }
        return false;
    }


    // 环形链表2
    @Test
    public void test142(){

    }

    //k个一组反转链表
    @Test
    public void test25(){

    }
    public ListNode reverseKGroup(ListNode head, int k) {


        return null;
    }

    /**
     *  跳表
     *   跳表无题目
     */


    /**
     *  home work部分
     */


    @Test
    public void test26(){

    }

    public int removeDuplicates(int[] nums) {
        int  slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                slow++;
                nums[slow]=nums[i];
            }
        }
        return slow+1;
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

}
