package _00_题型分类._09_贪心算法;

import java.util.Arrays;
import org.junit.Test;

public class _455_分发饼干 {


  /**
   * @Description
   * @Date 2021/3/23 18:50
   **/
  @Test
  public void test455() {

  }
  public int findContentChildren(int[] g, int[] s) {
    //胃口
    Arrays.sort(g);
    //饼干
    Arrays.sort(s);
    int gcount=0;

    for (int i = 0; i < s.length; i++) {
      if (s[i]>=g[gcount]) {
        gcount++;
        if (gcount== g.length) {
          return gcount;
        }
      }
    }
    return gcount;
  }
}
