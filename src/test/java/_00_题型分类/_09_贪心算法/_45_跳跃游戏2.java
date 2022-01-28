package _00_题型分类._09_贪心算法;

public class _45_跳跃游戏2 {


  public int jump(int[] nums) {
    int count =0 ;
    int cur =0 ;
    for (int i = 0; i < nums.length; i++) {
      var num = nums[i];
      if (cur+num> nums.length) {
        return  count++;
      }

      for (int j = 0; j < num; j++) {




      }

    }
    return  count;
  }
}
