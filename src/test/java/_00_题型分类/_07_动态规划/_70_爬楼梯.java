package _00_题型分类._07_动态规划;

import org.junit.Test;

public class _70_爬楼梯 {
  @Test
  public void test() {
    System.out.println(climbStairs(5));
  }
  //爬楼梯 test70  _00_题型分类.动态规划
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int[] arr = new int[n + 1];
    arr[1] = 1;
    arr[2] = 2;
    for (int i = 3; i <= n; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[n];
  }

}
