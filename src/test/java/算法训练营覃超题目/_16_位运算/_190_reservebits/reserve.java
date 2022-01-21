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
    int res= 0;
    for (int i = 0; i <= 31; i++) {
      int cur = (1 & (n>>i) ) << (31-i);
        res+= cur;
    }
    return res;
  }
}
