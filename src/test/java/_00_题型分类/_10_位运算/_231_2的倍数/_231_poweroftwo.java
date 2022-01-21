package _00_题型分类._10_位运算._231_2的倍数;

import java.util.Arrays;
import org.junit.Test;

public class _231_poweroftwo {

  /**
   * @Description
   * @Date 2022/1/20 10:13
   **/
  @Test
  public void test() {
    System.out.println(isPowerOfTwo(16));
  }

  /**
   * @Description  神奇的测试用例？？？？
   * @Date 2022/1/20 10:20
   **/
  @Test
  public void test2() {
    System.out.println(isPowerOfTwo(-2147483648));

  }

  public boolean isPowerOfTwo(int n) {
    if (n==0) {
       return  false;
    }
    if (n== -2147483648) {
      return  false;
    }
    String str = Integer.toBinaryString(n);
    char[] chars = str.substring(1).toCharArray();
    Arrays.sort(chars);
    if (chars.length==0) {
       return  true;
    }
    return chars[chars.length-1] =='0';
  }
}
