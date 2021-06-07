package leetbook.图解算法数据结构;

import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/4 11:08
 **/
public class _02动态规划 {

     //10-2青蛙跳台阶
    public int numWays(int n) {
        if (n==0 || n==1) {
             return 1;
        }

         int[] dp =new int[n+1];
         dp[0]=1;
         dp[1]=1;

        for (int i = 2; i <= n; i++) {
            dp[i]=(dp[i-2]+dp[i-1])%1000000007;
        }
        return dp[n];
    }

    //19 todo  矩形匹配推算的
    public boolean isMatch(String s, String p) {


         return  false;
    }


    //42
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length==1) {
             return nums[0];
        }
        int[] dp= new int[length];
        dp[0]=nums[0];
        int res =nums[0];
        for (int i = 1; i < length; i++) {
            dp[i]=Math.max(nums[i]+dp[i-1],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return  res;

    }
    //46 数字翻译成字符串

    /**
     * @Description
     * @Date 2021/6/4 14:41
     **/
    @Test
    public void test46() {
        System.out.println(translateNum(0));

    }
    public int translateNum(int num) {
        if (num==0) {
            return 1;
        }

        List<Integer>  list = new ArrayList<>();
        while (num!=0){
              list.add(num %10);
              num=num/10;
        }
        if (list.size()==1) {
              return  1;
        }
        int[]  arr = new int[list.size()];
        int j=0;
        for (int i = list.size()-1; i>=0; i-- ) {
               arr[j]= list.get(i);
                j++;
        }

        // dp
        int[] dp = new int[arr.length];
        dp[0]= 1;
        int  cur1= arr[0]*10 +arr[1];
        if (cur1<26&& cur1>9) {
             dp[1]=2;
        }else {
            dp[1]= 1;
        }

        for (int i = 2; i < arr.length; i++) {
            //dp方程
            int tmp=arr[i-1]*10 + arr[i];
            if (tmp>9 && tmp<26) {
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }

        }

        return  dp[arr.length-1];
    }

    //47 礼物的最大价值
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column=grid[0].length;
        int[][] res= new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //处理边界情况
                if (i==0) {
                     if(j==0){
                          res[0][0]= grid[0][0];
                          continue;
                     }
                     res[0][j]= grid[0][j]+ res[0][j-1];
                    continue;
                }
                if(j==0){
                     if(i==0){
                         continue;
                     }
                     res[i][0]=grid[i][0]+ res[i-1][0];
                    continue;
                }
                //非边界情况
                res[i][j]=Math.max(res[i-1][j],res[i][j-1])+ grid[i][j];
            }
        }

        return   res[row-1][column-1];
    }


    //48  todo 应该用动态规划来做，但是这写的太简单了
    //转移方程??
    /**
     * @Description
     * @Date 2021/6/7 10:04
     **/
    @Test
    public void test48() {
        System.out.println(lengthOfLongestSubstringDp("abcabcbb"));  //3
        System.out.println(lengthOfLongestSubstringDp("aab"));     //2
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) {
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        char[] chars = s.toCharArray();
        int res=0,tmp=-1;
        for (int i = 0; i < chars.length; i++) {
            Integer j= -1;
            if (map.containsKey(chars[i])) {
                 j= map.get(chars[i]);
            }
            map.put(chars[i],i);
            tmp= tmp<i-j?tmp+1:i-j;
            res=Math.max(res,tmp);
        }
        return res;
    }


    public int lengthOfLongestSubstringDp(String s) {
        if (s.length()==0) {
             return  0;
        }
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int[] dp= new  int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            Integer oldIndex = map.getOrDefault(chars[i], -1);
            map.put(chars[i],i);
            if (i==0) {
                dp[0]=1;
                continue;
            }

            //dp 错了
            if (dp[i-1]<i-oldIndex) {
                 dp[i]= dp[i-1]+1;
            }else{
                 dp[i]= i-oldIndex;
            }
//            dp[i]= Math.max(i-oldIndex,dp[i-1]+1);
        }
        return  dp[chars.length-1];
    }

    //49 丑数

    /**
     * @Description
     * @Date 2021/6/7 11:09
     **/
    @Test
    public void test49() {
        System.out.println(nthUglyNumber(3));


    }
    public int nthUglyNumber(int n) {
        int[] dp= new  int[n];
         dp[0]=1;
         int i=0,j=0,k=0;
        for (int l = 1; l < n; l++) {
            int xi = dp[i] * 2, xj = dp[j] * 3, xk = dp[k] * 5;
            dp[l] = Math.min(xi, Math.min(xj, xk));
            if (dp[l] == xi) i++;
            if (dp[l] == xj) j++;
            if (dp[l] == xk) k++;
        }
        return dp[n-1];
    }

    //60 n个筛子的电数

    /**
     * @Description
     * @Date 2021/6/7 11:27
     **/
    @Test
    public void test60() {
        System.out.println(dicesProbability(2));
    }
    public double[] dicesProbability(int n) {
        double[][]  dp=new double[n][];
        double[] dp0={1.0/6.0,1.0/6.0,1.0/6.0,1.0/6.0,1.0/6.0,1.0/6.0};
        dp[0]= dp0;

        for (int i = 1; i < n; i++) {
            double[]  predp = dp[i - 1];
            Map<Integer,Double>  map= new HashMap<>();
            for (int j = 0; j < predp.length; j++) {
                for (int k = 0; k < dp0.length; k++) {
                     map.put(k+j,map.getOrDefault(k+j,0.0)+ dp0[k]*predp[j]);
                }
            }
            double[]  dpi = new double[map.size()];
            int count=0;
            for (Double value : map.values()) {
                    dpi[count]=value;
                    count++;
            }
            dp[i]=dpi;
        }
        return dp[n-1];
    }

    //63
    public int maxProfit(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        int  maxProfit=0,minVal=prices[0];
        for (int price : prices) {
             minVal=Math.min(minVal,price);
             maxProfit=Math.max(maxProfit,price-minVal);
        }

        return maxProfit;
    }
}
