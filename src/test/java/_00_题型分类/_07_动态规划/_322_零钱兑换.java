package _00_题型分类._07_动态规划;

import java.util.Arrays;
import org.junit.Test;

public class _322_零钱兑换 {
  /**
   * @Description
   * @Date 2021/3/22 18:21
   **/
  @Test
  public void test322() {
    int[]   coins = {1, 2, 5};
    int amount = 11;
    System.out.println(coinChange(coins, amount));
  }

  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
