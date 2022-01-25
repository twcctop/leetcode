package _00_题型分类._10_位运算._2151_第几个人讲真话;

import org.junit.Test;
import util.ArrayUtil;

public class off {

   /**
    * @Description
    * @Date 2022/1/25
    *
    **/
   @Test
   public void test() {
      System.out.println(
          maximumGood(ArrayUtil.convertStringTwoDimensionIntArray("[[2,1,2],[1,2,2],[2,0,2]]")));
   }

//   https://leetcode-cn.com/problems/maximum-good-people-based-on-statements/solution/er-jin-zhi-mei-ju-by-endlesscheng-ttix/
   public int maximumGood(int[][] statements) {
      var ans = 0;
      var n = statements.length;
      // goto 的用法
      next:
      //  1<<n   2的n次方
      for (var i = 1; i < 1 << n; i++) {
         var cnt = 0; // i 中好人个数
         for (var j = 0; j < n; j++) {
            if (((i >> j) & 1) == 1) { // 枚举 i 中的好人 j
               for (var k = 0; k < n; k++) { // 枚举 j 的所有陈述
                  if (statements[j][k] < 2 && statements[j][k] != ((i >> k) & 1)) { // 该陈述与实际情况矛盾
                     continue next;
                  }
               }
               cnt++;
            }
         }
         ans = Math.max(ans, cnt);
      }
      return ans;
   }

   /**
    * @Description
    * @Date 2022/1/25 11:10
    **/
   @Test
   public void testSep() {
      System.out.println( 1<<3);
   }

}
