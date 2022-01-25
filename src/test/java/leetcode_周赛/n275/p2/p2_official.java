package leetcode_周赛.n275.p2;

public class p2_official {


  public int minSwaps(int[] nums) {
    int count = 0, ans = 0, num = 0;//分别用来记录数组内1总数、滑窗内1最大数、以及现在滑窗内1个数
    for (int i = 0; i < nums.length; i++) {
      count += nums[i];
    }
    //此时确定滑窗大小为count
    for (int i = 0; i < count; i++) {
      num += nums[i];
    }
    ans = num;
    for (int i = 0; i < nums.length - 1; i++) {
      num += nums[(count + i) % nums.length] - nums[i];
      ans = Math.max(ans, num);
    }
    return count - ans;
  }
}
