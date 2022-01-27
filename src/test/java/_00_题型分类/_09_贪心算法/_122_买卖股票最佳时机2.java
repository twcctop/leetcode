package _00_题型分类._09_贪心算法;

public class _122_买卖股票最佳时机2 {


  public int maxProfit(int[] prices) {

    int res= 0;
    for (int i = 1; i < prices.length; i++) {
      res += Math.max(prices[i]-prices[i-1],0);

    }
    return res;
  }
}
