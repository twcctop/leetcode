package leetcode_周赛.n275.p2;

import java.util.ArrayList;
import java.util.List;

public class p2 {

  public int minSwaps(int[] nums) {
    int length = nums.length;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        list.add(i);
      }
    }

    return  0;
  }

}

