package 力扣剑指offer;

import entity.ListNode;
import entity.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/5/27 14:43
 **/
public class offer_03_fjye {

    //51  todo 暴力超时
    public int reversePairs(int[] nums) {
        if (nums.length ==0 || nums.length==1) {
             return  0;
        }
        int[] curSum= new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
             int count=0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] >nums[j]) {
                     count++;
                }
            }
            curSum[i]=count;
        }
        int[] dp= new int[nums.length];
        dp[nums.length-1] = curSum[nums.length-1];
        for (int i = nums.length-2; i >=0; i--) {
              dp[i]=dp[i+1]+curSum[i];
        }
        return dp[0];
    }


    //52 两个链表公共节点
    //todo 不够优雅
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA!=null){
              ListNode curB = headB;
              while (curB!=null){
                  if (headA==curB) {
                      return  headA;
                  }
                  curB=curB.next;
              }
              headA=headA.next;
        }
        return   null;
    }
    //53   0- n-1 中缺失的数据
    public int missingNumber(int[] nums) {
        int j=nums.length-1;
        int i=0;
        while(i<=j){
            int m= (i+j)/2;
            if (nums[m]==m) {
                i=m+1;
            }else{
                 j=m-1;
            }
        }
      return  i;
    }
    //54  二叉树中第K大的节点
    class solution54{
        int res,k;
        public int kthLargest(TreeNode root, int k) {
            this.k=k;
            //二叉树的中序遍历是递增的
            dfs54(root);

            return res;
        }
        private void dfs54(TreeNode root) {
            if (root==null) {
                return;
            }
            dfs54(root.right);
            if (k==0) {
                return;
            }
            if (--k==0) {
                res=root.val;
            }
            dfs54(root.left);
        }
    }
    //55二叉树的深度

    /**
     * @Description
     * @Date 2021/5/28 11:03
     **/
    @Test
    public void test55() {
        TreeNode ndoe1=new TreeNode(1);
        System.out.println(maxDepthBFs(ndoe1));
    }
    public int maxDepthBFs(TreeNode root) {
         int[] depth=new int[1];
         depth[0]=0;

         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         bfs55(depth,queue);
         return depth[0];
    }

    private void bfs55(int[] depth, Queue<TreeNode> queue) {
        while (!queue.isEmpty()){
           depth[0]= depth[0]+1;
            Queue<TreeNode> newQue= new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if (null != treeNode.left) {
                    newQue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    newQue.add(treeNode.right);
                }

            }
            queue.clear();
            queue.addAll(newQue);
        }
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //55-2  平衡二叉树
    //todo 为什么不用加 状态判断符，直接返回true 或者false就可以
    public boolean isBalanced(TreeNode root) {
        if (null==root) {
             return  true;
        }
        return  Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1  &&   isBalanced(root.left) &&  isBalanced(root.right);
    }

    // 56-1  数组中数字出现次数
    //todo 解法不对  应该用异或运算？ 异或看不懂
    public int[] singleNumbers(int[] nums) {
        List<Integer> resList= new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i-1]!=nums[i] && nums[i]!=nums[i+1]) {
                resList.add(nums[i]);
            }
        }
        if (nums[0]!=nums[1]) {
             resList.add(nums[0]);
        }
        if (nums[nums.length-1]!=nums[nums.length-2]) {
             resList.add(nums[nums.length-1]);
        }
        int[] res =new  int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i]= resList.get(i);
        }
        return  res;
    }

    //57 和为s的两个数字
    public int[] twoSum(int[] nums, int target) {
         int i=0,j=nums.length-1;
         int[] res= new int[2];
         while(i<j){
             if (nums[i]+nums[j]==target) {
                 res[0]=nums[i];
                 res[1]=nums[j];
                 return res;
             }
             if (nums[i]+nums[j]<target) {
                  i++;
             }else{
                  j--;
             }
         }
        return  res;
    }
    //57-2  tofu
    // 和为s的连续正数序列   todo 看答案做的 , 答案也不对
    public int[][] findContinuousSequence(int target) {
        int i=1,j=2,s=3;
        List<int[]> res = new ArrayList<>();
        while(i<j){
            if (s==target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                    res.add(ans);
                }
            }
            if (s>=target) {
                 s-=i;
                 i++;
            }else {
                 j++;
                 s+=j;
            }
        }

        return res.toArray(new int[0][]);
    }

    // 58 翻转单词顺序  todo 实在无聊，不做了
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        return " ";
    }
    //58-2
    public String reverseLeftWords(String s, int n) {
        return " ";
    }

    //59-1  滑动窗口的最大值  todo 单调栈 做不出来
    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }

    //59-2 队列的最大值    todo  时间复杂度不是O1
    class MaxQueue {

        public MaxQueue() {
        }

        public int max_value() {
         return  0;
        }

        public void push_back(int value) {

        }

        public int pop_front() {
            return  0;
        }
    }
    //60
    public double[] dicesProbability(int n) {
        return null;
    }


}
