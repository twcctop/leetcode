package 算法训练营覃超题目;

import org.junit.Test;
import util.ArrayUtil;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.*;

/**
 * @Author: twc
 * @Date 2021/4/19 15:34
 **/
public class _19高级动态规划 {

    /**
     * @Description 买卖股票的最佳时机
     * @Date 2021/4/26 10:22
     **/
    @Test
    public void test121() {
        int[] ints = ArrayUtil.convertStringIntToArray(" [7,6,4,3,1]");
        System.out.println(maxProfit(ints));
    }

    public int maxProfit(int[] prices) {
        int maxPorfit = 0;
        int lowPrice = prices[0];
        for (int price : prices) {
            lowPrice = Math.min(price, lowPrice);
            maxPorfit = Math.max(maxPorfit, price - lowPrice);
        }
        return maxPorfit;
    }

    /**
     * @Description
     * @Date 2021/4/26 10:48
     **/
    @Test
    public void test746() {
        System.out.println(minCostClimbingStairs(ArrayUtil.convertStringIntToArray(" [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]")));
    }


    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        for (int n = 2; n < cost.length; n++) {
            dp[n] = Math.min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2]);
        }
        return Math.min(dp[cost.length - 1] + cost[cost.length - 1], dp[cost.length - 2] + cost[cost.length - 2]);
    }

    /**
     * @Description
     * @Date 2021/4/26 11:10
     **/
    @Test
    public void test300() {
        System.out.println(lengthOfLIS(ArrayUtil.convertStringIntToArray("[10,9,2,5,3,7,101,18]")));
    }

    public int lengthOfLIS(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int minSub  =  Integer.MAX_VALUE;
//            int flag =0;

            for (Map.Entry<Integer, Integer> en : map.entrySet()) {
                minSub=  Math.min(en.getKey(), minSub);
                if (en.getKey() < num) {
                    Integer value = en.getValue();
                    // map 中循环删除或者添加元素
                    map.remove(en.getKey());
                    map.put(num, ++value);
                    continue;
                }
            }
             if(num<minSub){
                 map.put(num, 1);
             }

//            if (flag ==1) {
//
//            }
        }
        int res= 1;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
              res=Math.max(en.getValue(),res);
        }
        return  res;
    }

    /**
     * [0,1,0,3,2,3]
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
             return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] =1;
        int maxans = 1;
        for (int i = 0; i < nums.length; i++) {
             dp[i] =1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) {
                    dp[i]= Math.max(maxans,dp[i]);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return  maxans;
    }

    /**
     * @Description
     * @Date 2021/4/27 15:38
     **/
    @Test
    public void test91() {
        // 预期 3
//        String demo1= "1201234";

        String demo1= "1123";
        System.out.println(numDecodings(demo1));

    }
    public int numDecodings(String s) {

        if (s.equals("0")||s.startsWith("0")) {
             return  0;
        }
        char[] chars = s.toCharArray();

        int[] dp= new int[chars.length];
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
             int sum = Character.getNumericValue(chars[i-1]) * 10  + Character.getNumericValue(chars[i]) ;
            if ( sum>0  && sum<27 ) {
                // 2101 中间为0 的情况
                if (i!=chars.length-1) {
                    if (Character.getNumericValue(chars[i+1]) ==0) {
                        dp[i]= dp[i-1];
                        continue;
                    }
                }
                 dp[i] = dp[i-1]+1;
            }else{
                 dp[i]= dp[i-1];
            }
        }
        return dp[chars.length-1];
    }

    /**
     * @Description 最长有效括号
     * @Date 2021/4/27 16:49
     **/
    @Test
    public void test32() {
    }

    public int longestValidParentheses(String s) {

        return 0;
    }

}
