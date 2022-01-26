package _00_题型分类._11_记忆化搜索._322_零钱兑换;

import org.junit.Test;
import util.ArrayUtil;

public class a {
  int cur = Integer.MAX_VALUE;
  public int coinChange(int[] coins, int amount) {
    int[] a = new int[1];
    dfs(a, coins, amount);

    if(cur==Integer.MAX_VALUE){
       return  -1;
    }
    return cur;
  }

  public void dfs(int[] a, int[] coins, int amount) {
      System.out.println(a[0] + "--------------" + amount);
    if (amount == 0) {
      cur = Math.min(cur, a[0]);
      return;
    }
    if (amount < 0) {
      return;
    }

    for (int i = 0; i < coins.length; i++) {
      int[] clone = new int[1];
      clone[0] = a[0]+1;
      dfs(clone, coins, amount - coins[i]);
    }
  }


  /**
   * @Description
   * @Date 2022/1/26 10:32
   **/
  @Test
  public void test() {
    int[] ints = ArrayUtil.convertStringIntToArray("[1, 2, 5]");
    System.out.println(coinChange(ints, 11));
  }

  /**
   * 超时了，很奇怪
   */
  @Test
  public void test2() {
    int[] ints = ArrayUtil.convertStringIntToArray("[1, 2, 5]");
    System.out.println(coinChange(ints, 100));
  }
}