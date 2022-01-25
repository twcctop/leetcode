package leetcde_双周赛._n70.p2;

import java.util.Arrays;
import org.junit.Test;
import util.ArrayUtil;

public class p2 {

  /**
   * @Description
   * @Date 2022/1/22 22:44
   **/

  @Test
  public void test3() {
    int[] ints = ArrayUtil.convertStringIntToArray("[4,-7,2]");
    System.out.println(numberOfArrays2(ints,3,6));
  }
  @Test
  public void test2() {
    int[] ints = ArrayUtil.convertStringIntToArray(" [3,-4,5,1,-2]");
    System.out.println(numberOfArrays2(ints,-4,5));
  }

  @Test
  public void test1() {
    int[] ints = ArrayUtil.convertStringIntToArray("[1,-3,4]");
    System.out.println(numberOfArrays2(ints,1,6));
  }

  // 60
  @Test
  public void test4() {
    int[] ints = ArrayUtil.convertStringIntToArray("[-40]");
    System.out.println(numberOfArrays2(ints,-46,53));
  }

  public int numberOfArrays2(int[] differences, int lower, int upper) {
    int sum  =Arrays.stream(differences).sum();
    int count = 0;
    for (int i = lower; i < upper-differences.length; i++) {
       int cur =i + sum;
      if (cur < upper&& cur>=lower ) {
        count++;
      }
    }
    return  count;
  }

}
