package _00_题型分类._10_位运算._338_比特位计数;

import org.junit.Test;
import util.ArrayUtil;

public class officail {

  @Test
  public void test() {
    ArrayUtil.printIntArray(countBits(2));
    ArrayUtil.printIntArray(countBits(5));
  }

//  https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/

  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      if ((i & 1) == 0) {  //  判断是否为奇数
        result[i] = result[i >> 1];
      } else {
        result[i] = result[i - 1] + 1;
      }
    }
    return result;
  }




}
