package leetbook._04_高级算法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _01_数组和字符串 {

    // 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {

        return null;

    }

    //测试提交
    //测试提交记录2
    //测试提交记录3
    //测试提交记录4

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

    // 缺失的第一个正数  todo hard难度
    //  todo hash法 无法理解
    public int firstMissingPositive(int[] nums) {



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


     // 寻找重复数  //todo  二分法不能理解
     public int findDuplicate(int[] nums) {

        return 0;
     }

}
