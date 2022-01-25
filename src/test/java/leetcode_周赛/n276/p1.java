package leetcode_周赛.n276;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import util.ArrayUtil;

public class p1 {
  /**
   * @Description
   * @Date 2022/1/16 10:37
   * <p>
   * "ctoyjrwtngqwt" 8 "n"
   **/
  @Test
  public void test1() {
//    String[] strings = divideString("", 3, 'x');
    String[] strings = divideString("ctoyjrwtngqwt", 8, 'n');
    ArrayUtil.printStringArray(strings);
  }

  public String[] divideString(String s, int k, char fill) {
    List<String> res = new ArrayList<>();
    char[] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      if (sb.length() == k) {
        res.add(sb.toString());
        sb.setLength(0);
      }
      sb.append(chars[i]);
    }
    if (sb.length() == k) {
      res.add(sb.toString());
      sb.setLength(0);
    }

    if (sb.length() > 0) {
      while (sb.length() != k) {
        sb.append(fill);
      }
      res.add(sb.toString());
    }

    String[] resArray = new String[res.size()];
    for (int i = 0; i < resArray.length; i++) {
      resArray[i] = res.get(i);
    }
    return resArray;
  }

}
