package _00_题型分类._10_位运算._338_比特位计数;

import org.junit.Test;
import util.ArrayUtil;

public class _338_countBits {


  /**
   * @Description
   * @Date 2022/1/21 15:36
   **/
  @Test
  public void test() {
    ArrayUtil.printIntArray(countBits( 2)) ;
    ArrayUtil.printIntArray(countBits( 5)) ;
  }

  public int[] countBits(int n) {
       int[] a =new int[31];
    for (int i = 1; i <=31; i++) {
      a[31-i] = n>>i &1;
    }

    return  a;

  }

  /**
   * @Description
   * @Date 2022/1/21 15:43
   **/
  @Test
  public void test2() {

    System.out.println( 2>>0);
    System.out.println( 2>>1);
    System.out.println( 2>>2);
  }
}
