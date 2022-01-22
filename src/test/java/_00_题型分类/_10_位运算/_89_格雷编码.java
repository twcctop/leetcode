package _00_题型分类._10_位运算;

import java.util.ArrayList;
import java.util.List;

public class _89_格雷编码 {
//  https://leetcode-cn.com/problems/gray-code/


  public List<Integer> grayCode(int n) {
    List<Integer> ret = new ArrayList<Integer>();
    for (int i = 0; i < 1 << n; i++) {
      ret.add((i >> 1) ^ i);
    }
    return ret;

  }

}
