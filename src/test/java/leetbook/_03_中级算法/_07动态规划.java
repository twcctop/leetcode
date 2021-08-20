package leetbook._03_中级算法;

/**
 * @Author: twc
 * @Date 2021/6/26 20:04
 **/
public class _07动态规划 {

    // 不同路径的问题
    public int uniquePaths(int m, int n) {
        int[][]   doubleArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            doubleArr[i][0]=1;
        }
        for (int i = 0; i < 0; i++) {
            doubleArr[0][i]= 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                doubleArr[i][j]=  doubleArr[i-1][j] + doubleArr[i][j-1];
            }
        }
        return doubleArr[m-1][n-1];
    }
    // 零钱兑换 todo 看不懂
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i) {
                    // 为什么这样写
                    dp[i]= Math.min(dp[i],dp[i- coins[j]] +1);
                }

            }
        }
        return dp[amount]> amount ? -1:dp[amount];
    }

    //最长上升子序列
    public int lengthOfLIS(int[] nums) {
         return  0;
    }

}
