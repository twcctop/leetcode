package 算法训练营覃超题目._16_位运算._190_reservebits;

import org.junit.Test;

public class reserve {


  /**
   * @Description
   * @Date 2022/1/20 10:40
   **/
  @Test
  public void test() {

  }

  public int reverseBits(int n) {
    if (n == 0) {
      return 0;
    }
    int res = 1;
    for (int i = 1; i < 32; i++) {
      res = 10 * res + (n >> i);
    }
    return res;
  }
}
