package 算法训练营覃超题目._16_位运算._190_reservebits;

import org.junit.Test;

public class off {

  /**
   * @Description
   * @Date 2022/1/21 11:23
   **/
  @Test
  public void test() {

    System.out.println(reverseBits(43261596));
  }

  /**
   * @Description
   * @Date 2022/1/21 11:45
   **/
  @Test
  public void test2() {
    System.out.println(reverseBits(43261596));
  }

  public int reverseBits(int n) {
    int rev = 0;
    for (int i = 0; i < 32 && n != 0; ++i) {
      rev |= (n & 1) << (31 - i);
      n >>>= 1;
    }
    return rev;
  }




  public int reverseBits2(int n) {
    int res = 0;      //首先初始化一个存放结果的整数a
    for(int i =0;i<=31;i++){
      int cur = (1 & (n >> i)) << (31 - i);
      res+=cur;
      //首先n>>i表示每次n向右移一位
      //1&一个二进制数表示的是取出该二进制数的最后一位
      //将最后一位取出以后，向左移动31-i位，将其加入到结果中即可。多次循环，最终可以得到目标值。
    }
    return res;
  }


}
