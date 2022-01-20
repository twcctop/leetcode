package 算法训练营覃超题目._16_位运算;

import org.junit.Test;

public class _191_hammingWeight {

  /**
   * @Description
   * @Date 2022/1/20 9:46
   **/
  @Test
  public void test() {
    //   idea debug得知  读取成8进制的，很怪异
    System.out.println(hammingWeight(00000000000000000000000000001011));
//        System.out.println(hammingWeight(1011));
//        System.out.println(hammingWeight(00000000000000000000000000000010));
  }

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      int a = n >> i;
      int b = a & 1;
      if (b == 1) {
        count++;
      }
    }
    return count;
  }


  public int hammingWeight2(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
        int a = n>>i;
      if ( (a & 1) ==1) {
        count++;
      }
    }
    return count;


  }

}
