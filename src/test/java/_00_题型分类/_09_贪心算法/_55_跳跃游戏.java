package _00_题型分类._09_贪心算法;

import org.junit.Test;

public class _55_跳跃游戏 {

  /**
   * @Description
   * @Date 2022/1/27 15:47
   **/
  @Test
  public void test() {
  }
  public boolean canJump(int[] nums) {
    if (nums.length==0||nums.length==1) {
      return true;
    }
    int maxlen= 0;
    for (int i = 0; i < nums.length; i++) {
      if (i<=maxlen) {
        maxlen= Math.max(maxlen,i+nums[i]);
      }
    }
    return    maxlen>=nums.length-1;
  }
}
