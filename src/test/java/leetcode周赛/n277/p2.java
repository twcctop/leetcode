package leetcode周赛.n277;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import util.ArrayUtil;

public class p2 {

  /**
   * @Description  [3,-2,1,-5,2,-4]
   * @Date 2022/1/23 10:45
   **/
  @Test
  public void test() {

    ArrayUtil.printIntArray(rearrangeArray(ArrayUtil.convertStringIntToArray("[3,1,-2,-5,2,-4]")));
  }

  public int[] rearrangeArray(int[] nums) {
    Deque<Integer> a = new LinkedList<>();
    Deque<Integer> b = new LinkedList<>();
    for (int num : nums) {
      if(num>0){
        a.addFirst(num);
      }else {
        b.addFirst(num);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (i%2==0) {
        nums[i]=  a.pollLast();
      }else {
        nums[i] = b.pollLast();
      }
    }

    return  nums;


  }
}
