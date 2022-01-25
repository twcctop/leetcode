package leetcode_周赛.n277;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import util.ArrayUtil;

public class p3 {

  /**
   * @Description
   * @Date 2022/1/23 10:49
   **/
  @Test
  public void test() {
    System.out.println(findLonely(ArrayUtil.convertStringIntToArray("[10,6,5,8]")));

  }

  /**
   * @Description
   * @Date 2022/1/23 11:00
   **/
  @Test
  public void test2() {
    System.out.println(findLonely(ArrayUtil.convertStringIntToArray("[0]")));
  }


  public List<Integer> findLonely(int[] nums) {
    if (nums.length==1) {
      return  Arrays.asList(nums[0]);
    }

    Arrays.sort(nums);
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (i==0) {
        if (nums[0]<nums[1]-1) {
           res.add(nums[0]);

        }
        continue;
      }
      if(i==nums.length-1){
         if(nums[nums.length-1]>nums[nums.length-2]+1){
            res.add(nums[nums.length-1]);
         }
            continue;
      }

      if (nums[i] >nums[i-1]+1 && nums[i]<nums[i+1]-1) {
         res.add(nums[i]);
      }

    }
    return res;
  }

  /**
   * @Description
   * @Date 2022/1/25 10:29
   **/
  @Test
  public void test3() {



  }
}
