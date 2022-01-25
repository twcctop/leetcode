package leetcode_周赛.n277;

import java.util.Arrays;
import org.junit.Test;

public class p1 {


  /**
   * @Description
   * @Date 2022/1/23 10:31
   **/
  @Test
  public void test() {
  }
  public int countElements(int[] nums) {
    if (nums.length>2) {
      int count =0;
      Arrays.sort(nums);
      for (int i = 1; i < nums.length-1; i++) {
        if (nums[i]>nums[0] &&  nums[i] <nums[nums.length-1]) {
           count++;
        }
      }
      return  count;


    }
     return  0;
  }
}
