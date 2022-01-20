package 算法训练营覃超题目._16_位运算._190_reservebits;

public class off {


  public int reverseBits(int n) {
    int rev = 0;
    for (int i = 0; i < 32 && n != 0; ++i) {
      rev |= (n & 1) << (31 - i);
      n >>>= 1;
    }
    return rev;
  }


}
