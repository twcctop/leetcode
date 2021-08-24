package leetbook._04_高级算法;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class _01_数组和字符串 {

    // 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left =new int[length];
        int[] right= new int[length];
        int[] res= new int[length];

        left[0]=1;
        for (int i = 1; i < left.length; i++) {
             left[i]= nums[i-1]*left[i-1];
        }

        right[length-1]=1;
        for (int i = length-2; i>=0; i--) {
             right[i]= nums[i+1]* right[i+1];
        }


        for (int i = 0; i < length; i++) {
            res[i]=left[i]*right[i];
        }

        return res;

    }


    //四数相加2
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int u : nums1) {
            for (int v : nums2) {
                map.put(u + v, map.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                if (map.containsKey(-u-v)) {
                    ans+=map.get(-u-v);
                }

            }
        }
        return  ans;
    }
    //盛水最多的容器 , 莫名其妙通过了
    public int maxArea(int[] height) {
        int left= 0,right= height.length-1;
        int res=0;
        while(left<right){
            res= Math.max(Math.min(height[left],height[right])* (right-left),res);

            if (height[left]<=height[right]) {
                left++;

            }else{
                right--;
            }
        }
        return res;
    }
    //生命游戏
    public void gameOfLife(int[][] board) {

    }

    // 缺失的第一个正数  todo  hard难度
    // 缺失的第一个正数  todo hard难度
    //  todo hash法 无法理解
    public int firstMissingPositive(int[] nums) {
        int n= nums.length;
        for (int i = 0; i < n; i++) {

        }

        return 0;
    }

    // 寻找重复数
    //https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419
    // todo 二分法  无法理解
    public int findDuplicate(int[] nums) {


        return  0;
    }

    // 基本计算器2  栈解决  +- 则入栈，乘除则获取栈顶元素 计算后压入
    public int calculate(String s) {
            return 0;


    }
    // 最长连续序列  hash表算出来   todo  超时，逻辑换一下
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res =1;
        for (int i = 0; i < nums.length; i++) {
             int count=1 ;
             int cur= nums[i];
             while(set.contains(cur+1)){
                 cur++;
                 count++;
              }
             res= Math.max(res,count);

        }
        return  res;
    }


     // 滑动窗口最大值  https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
    // 左程云
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque =new LinkedList<>();
        int cur=0,max=0;
        for (int i = 0; i < k; i++) {
             deque.addLast(nums[i]);
             cur+=nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            deque.addLast(nums[i]);
            Integer pollFirst = deque.pollFirst();
            int curInCycle=cur-pollFirst+nums[i];
            max=Math.max(curInCycle,cur);
            cur= curInCycle;
        }
        return null;
    }
    //测试提交1



}
