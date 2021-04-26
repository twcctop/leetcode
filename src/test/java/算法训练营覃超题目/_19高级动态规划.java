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
    public int lengthOfLISOffical(int[] nums) {


     return  0;
    }
}
