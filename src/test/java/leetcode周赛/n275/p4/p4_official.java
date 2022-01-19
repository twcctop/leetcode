package leetcode周赛.n275.p4;

import java.util.Arrays;
import org.junit.Test;

public class p4_official {

  /**
   * @Description
   * @Date 2022/1/19 11:03
   **/
  @Test
  public void test() {

  }


  public int earliestFullBloom(int[] plantTime, int[] growTime) {
    int n = plantTime.length, res = 0, plant = 0;

    int[][] grow = new int[n][2];
    for (int i = 0; i < n; i++) {
      grow[i][0] = growTime[i];
      grow[i][1] = i;
    }
    Arrays.sort(grow, (a, b) -> b[0] - a[0]);

    for (int i = 0; i < n; i++) {
      plant += plantTime[grow[i][1]];
      res = Math.max(res, plant + grow[i][0]);
    }
    return res;
  }
}
