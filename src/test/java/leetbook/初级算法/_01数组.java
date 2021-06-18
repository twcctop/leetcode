package leetbook.初级算法;

import com.sun.javafx.logging.JFRInputEvent;
import org.junit.Test;
import util.ArrayUtil;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/7 11:59
 **/
public class _01数组 {

    /**
     * @Description
     * @Date 2021/6/7 12:06
     **/
    @Test
    public void test() {
        System.out.println(removeDuplicates(ArrayUtil.convertStringIntToArray("[1,1,2]")));
    }
    public int removeDuplicates(int[] nums){
        int slow=0;
        for (int i = 0; i < nums.length; i++) {
            if (i==0) {
                slow++;
                continue;
            }
            if (nums[i]==nums[i-1]) {
                continue;
            }else {
                nums[slow]=nums[i];
                slow++;
            }
        }
        return  slow;
    }

    public int maxProfit(int[] prices) {
         int res=0;
         int minVa = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
             minVa=Math.min(minVa,prices[i]);
            if (prices[i]>minVa) {
                  res+= prices[i]-minVa;
                  minVa=prices[i];
            }

        }
         return  res;
    }

    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if (k==0) {
             return;
        }
        int[]  res=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int offset=i-k;
            if (offset < 0) {
                offset += nums.length;
            }
            res[i]= nums[offset];
        }
        System.arraycopy(res,0,nums,0,res.length);
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]) {
                 return  true;
            }
        }
        return false;
    }

    //todo 时间复杂度不对
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length==1) {
            return nums[0];
        }

        if (nums[0]!=nums[1]) {
             return nums[0];
        }
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]!=nums[i-1] && nums[i]!=nums[i+1]) {
                 return  nums[i];
            }
        }
        if(nums[nums.length-1]!=nums[nums.length-2]){
             return nums[nums.length-1];
        }
        return 0;
    }

    //两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
         Set<Integer> set=new HashSet<Integer>();
        for (int i : nums1) {
             set.add(i);
        }
        List<Integer> list= new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)&&!list.contains(i)) {
                 list.add(i);
            }
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
             res[i]= list.get(i);
        }
        return  res;
    }

    public void moveZeroes(int[] nums) {
        int slow=0,fast=0;
         while(fast<nums.length){
             if (nums[fast]!=0) {
                  nums[slow]=nums[fast];
                  fast++;
                  slow++;
             }else if(nums[fast]==0){
                  fast++;
             }
         }
        for (int i = slow; i < nums.length; i++) {
             nums[i]=0;
        }
    }

    // 有效的数独
    public boolean isValidSudoku(char[][] board) {

        return  false;
    }

}
