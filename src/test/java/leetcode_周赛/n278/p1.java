package leetcode_周赛.n278;

import java.util.Arrays;
import org.junit.Test;

public class p1 {


  /**
   * @Description
   * @Date 2022/1/30 10:32
   **/
  @Test
  public void test() {

  }

  public int findFinalValue(int[] nums, int original) {
    Arrays.sort(nums);
    for (int num : nums) {
      if (num==original) {
         original= original*2;
      }

    }
    return  original;
  }
}
