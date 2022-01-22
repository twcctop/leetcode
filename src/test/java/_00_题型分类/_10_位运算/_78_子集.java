package _00_题型分类._10_位运算;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import util.ArrayUtil;

public class _78_子集 {

  /**
   * @Description
   * @Date 2022/1/22 10:11
   **/
  @Test
  public void test() {
    System.out.println(subsets(ArrayUtil.convertStringIntToArray("[1,2,3]")));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>>  res =new ArrayList<>();

    //8   00000001
    for (int i = 0; i <(Math.pow(2 , nums.length)) ; i++) {
      List<Integer> list = new ArrayList<>();
      //3
      for (int j = 0; j < nums.length; j++) {


        if ( ((i>>j) & 1)==1) {
           list.add(nums[j]);
        }
      }
     res.add(list);
    }
    return res;
  }

  /**
   * @Description
   * @Date 2022/1/22 10:37
   **/
  @Test
  public void test2() {
    System.out.println(Math.pow(2, 3));
    System.out.println( 2^3);
  }
}
