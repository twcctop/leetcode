package leetcode_每日一题;

import org.junit.Test;

public class _0127_2047 {

  /**
   * @Description
   * @Date 2022/1/27 15:12
   **/
  @Test
  public void test() {
  }
  public int countValidWords(String sentence) {
    int res =0;
    var split = sentence.split("0");

    for (String s : split) {
      var trim = s.trim();
      if (trim.matches(".*\\\\d.*")) {
        continue;
      }
      res++;
    }

    return  res;
  }

}
