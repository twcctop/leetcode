package leetcode周赛.n276;

import java.util.Arrays;
import org.junit.Test;


public class p4 {
//  https://leetcode-cn.com/contest/weekly-contest-276/

  /**
   * @Description
   * @Date 2022/1/16 14:55
   **/
  @Test
  public void test() {
  }




  public long maxRunTime(int n, int[] batteries) {
    if (batteries.length < n) {
      return 0;
    }
    int batteriesCount = 0;
    for (int i = 0; i < batteries.length; i++) {
      batteriesCount += batteries[i];
    }


    Arrays.sort(batteries);

   int average =   batteriesCount / n;
   int newC =0;
    for (int i = 0; i < batteries.length; i++) {
      if (batteries[i]>average) {
         newC += average;
      }else {
        newC += batteries[i];
      }
    }

    return Long.valueOf(newC/average);

  }



}



