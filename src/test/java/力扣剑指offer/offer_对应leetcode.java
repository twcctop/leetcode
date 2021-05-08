package 力扣剑指offer;

import org.junit.Test;

/**
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
}
