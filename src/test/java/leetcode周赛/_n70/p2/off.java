package leetcode周赛._n70.p2;

import java.util.Arrays;
import org.junit.Test;
import util.ArrayUtil;

public class off {


  // 60
  @Test
  public void test4() {
    int[] ints = ArrayUtil.convertStringIntToArray("[-40]");
    System.out.println(numberOfArrays2(ints, -46, 53));
  }


  public int numberOfArrays2(int[] differences, int lower, int upper) {
    int min_v = 0, max_v = 0, cur = 0;

    for (int diff : differences) {
      int next = cur + diff;
      min_v = Math.min(min_v, next);
      max_v = Math.max(max_v, next);
      cur = next;
    }

    int res = (upper - lower) - (max_v - min_v) + 1;
    return Math.max(res, 0);
  }

}
