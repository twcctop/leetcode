package _00_题型分类._10_位运算._231_2的倍数;

import org.junit.Test;

public class official {
  public boolean isPowerOfTwo(int n) {

    return  n>0   && (  (n & (n - 1)) ==0 ) ;
  }



  /**
   * @Description
   * @Date 2022/1/20 10:29
   **/
  @Test
  public void testAnd() {
    int a1 = 4;
    System.out.println(a1 & (a1 - 1));
  }


}