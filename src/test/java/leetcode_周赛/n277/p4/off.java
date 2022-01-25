package leetcode_周赛.n277.p4;

import org.junit.Test;

public class off {
//   https://leetcode-cn.com/problems/maximum-good-people-based-on-statements/solution/er-jin-zhi-mei-ju-by-endlesscheng-ttix/
   public int maximumGood(int[][] statements) {
      var ans = 0;
      var n = statements.length;
      // goto 的用法
      next:
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
    * @Date 2022/1/25 10:32
    **/
   @Test
   public void test() {



   }

}
