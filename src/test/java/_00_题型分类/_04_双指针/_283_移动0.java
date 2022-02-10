package _00_题型分类._04_双指针;

import org.junit.Test;

public class _283_移动0 {


  //移动零
  @Test
  public void test283(){

  }
  public void moveZeroes(int[] nums) {
    int len = nums.length;
    int slow= 0;
    for (int fast = 0; fast < len; fast++) {
      if (nums[fast] !=0) {
        nums[slow]=nums[fast];
        slow++;
      }
    }
    for(int j =slow;j<len;j++){
      nums[j]=0;
    }

  }
}
