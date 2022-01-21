package 算法训练营覃超题目._16_位运算;

import org.junit.Test;
import util.ArrayUtil;

public class _136_singleNumber {


  /**
   * @Description
   * @Date 2022/1/21 12:02
   **/
  @Test
  public void test() {
    int[] ints = ArrayUtil.convertStringIntToArray("[2,2,1]");
    System.out.println(singleNumber(ints));

  }

  public int singleNumber(int[] nums) {
    int single = 0;
    for (int num : nums) {
      single ^= num;
    }
    return single;
  }
//
//  作者：LeetCode-Solution
//  链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  /**
   * @Description
   * @Date 2022/1/21 12:03
   **/
  @Test
  public void testA() {
    int a1 =1;
    System.out.println(a1 ^=1);
    System.out.println(a1);
    System.out.println(a1 ^=2);
    System.out.println(a1);

    System.out.println(a1 ^=3);
    System.out.println(a1);
  }
}
