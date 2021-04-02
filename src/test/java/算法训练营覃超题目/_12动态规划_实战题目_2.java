package 算法训练营覃超题目;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/3/27 15:07
 **/
public class _12动态规划_实战题目_2 {
    /**
     * @Description
     * @Date 2021/4/1 17:26
     **/
    @Test
    public void test198() {
//        int[] arr= {2,7,9,3,1};
        int[] arr= {1,2,3,1};
        System.out.println(robSingle(arr));
    }

    public int robSingle(int[] nums) {
        if (nums.length==1) {
             return nums[0];
        }
       int[] dp = new int[nums.length];
       dp[0]=nums[0];
       dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    /**
     * @Description
     * @Date 2021/4/1 17:39
     **/
    @Test
    public void test213() {
        int[] a ={1,2,3,1};
        int[] b ={1,2,1,1};
//        System.out.println(rob2(a));
        System.out.println(rob2(b));


    }
    public int rob2(int[] nums) {
        if (nums.length==1) {
             return nums[0];
        }
        if (nums.length==2) {
            return Math.max(nums[0],nums[1]);
        }
        if (nums.length==3) {
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }

        int[]  subNum1= new int[nums.length-3];
        int[]  subNum2= new int[nums.length-1];
        int length = nums.length;
        System.arraycopy(nums,1,subNum1,0,length-3);
        System.arraycopy(nums,0,subNum2,0,length-1);
        return Math.max(robSingle(subNum1)+nums[nums.length-1], robSingle(subNum2));
    }

    /**
     * @Description  买卖股票的最佳时机
     * @Date 2021/4/1 18:09
     **/
    @Test
    public void test121() {
        int[]    a= {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
    public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for (int price : prices) {
            if (minprice>price) {
                 minprice = price;
            }else {
                 maxprofit = Math.max(price-  minprice,maxprofit);
            }
        }
         return  maxprofit;
    }

    /**
     * @Description
     * @Date 2021/4/1 18:29
     **/
    @Test
    public void test122() {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(a));
    }
    public int maxProfit2(int[] prices) {
        if (prices.length ==1) {
             return   0 ;
        }
        int maxprofit = 0;
        int startprice=prices[0];
        for (int price : prices) {
            if (startprice ==price) {
                 continue;
            }
            if (price>startprice) {
                maxprofit+=price-startprice;
                startprice= price;
            }
            if(price<startprice){
                startprice= price;
            }
        }
         return  maxprofit;
    }

    /**
     * @Description
     * @Date 2021/4/1 18:44
     **/
    @Test
    public void test123() {
//         int[] a ={3,3,5,0,0,3,1,4};
         int[] b ={1,2,3,4,5};
//        System.out.println(maxProfit3(a));
        System.out.println(maxProfit3(b));
    }
    public int maxProfit3(int[] prices) {
        if (prices.length ==1) {
            return   0 ;
        }
        List<Integer> maxprofitList = new ArrayList<>();
        int maxprofit = 0;
        int startprice=prices[0];
        for (int price : prices) {
            if (startprice ==price) {
                continue;
            }
            if (price>startprice) {
                maxprofitList.add(price-startprice);
                maxprofit+=price-startprice;
                startprice= price;
            }
            if(price<startprice){
                startprice= price;
            }
        }

        Collections.sort(maxprofitList);
        return   maxprofitList.get(maxprofitList.size()-1)+maxprofitList.get(maxprofitList.size()-2);

//        return  maxprofit;
    }

}
