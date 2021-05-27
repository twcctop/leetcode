package 力扣剑指offer;

import org.junit.Test;

/**
 * @decription: 其实这个类没有必要存在， 不用写两遍重复的代码
 * @Author: twc
 * @Date 2021/5/8 14:20
 **/
public class offer_对应leetcode {

    /**
     * @Description
     * @Date 2021/5/8 14:20
     **/


    @Test
    public void test343() {
        System.out.println(integerBreak(2));
    }


    //todo  看答案的
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <=n; i++) {
             int curMax=0;
            for (int j = 0; j < i; j++) {
                 curMax = Math.max(curMax,Math.max(j*dp[i-j],j*(i-j)));
            }
            dp[i]= curMax;
        }
        return dp[n];
    }

    /**
     * @Description
     * @Date 2021/5/10 16:58
     **/
    @Test
    public void test10() {


    }

    public boolean isMatch(String s, String p) {

        return  true;
    }

    /**
     * @Description  34
     * @Date 2021/5/27 15:29
     **/
    @Test
    public void test34() {

    }
    public int[] searchRange(int[] nums, int target) {
        return  new int[2];
    }
}
