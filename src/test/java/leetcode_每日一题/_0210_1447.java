package leetcode_每日一题;

import java.util.ArrayList;
import java.util.List;

public class _0210_1447 {

  public List<String> simplifiedFractions(int n) {
    List<String> ans = new ArrayList<String>();
    for (int denominator = 2; denominator <= n; ++denominator) {
      for (int numerator = 1; numerator < denominator; ++numerator) {
        if (gcd(numerator, denominator) == 1) {
          ans.add(numerator + "/" + denominator);
        }
      }
    }
    return ans;
  }

  public int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }


}
