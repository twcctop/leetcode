package _00_题型分类._10_位运算;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _90_子集2 {



  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Set<List<Integer>> set = new HashSet<>();

    //8   00000001
    for (int i = 0; i <(Math.pow(2 , nums.length)) ; i++) {
      List<Integer> list = new ArrayList<>();
      //3
      for (int j = 0; j < nums.length; j++) {


        if ( ((i>>j) & 1)==1) {
          list.add(nums[j]);
        }
      }
      set.add(list.stream().sorted().collect(Collectors.toList()));
    }
    return new ArrayList<>(set);
  }
}
