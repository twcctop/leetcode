package leetcode周赛.n276;

import org.junit.Test;

public class p2 {
  /**
   * @Description
   * @Date 2022/1/16 10:59
   **/
  @Test
  public void test2() {
//    System.out.println(minMoves( 19,2));
    System.out.println(minMoves(5, 0));

  }


  int count = 0;

  public int minMoves(int target, int maxDoubles) {
    if (target == 1) {
      return count;
    }

    if (maxDoubles == 0) {
      return count + target - 1;
    }

    if (target % 2 == 0) {
      target = target / 2;
      maxDoubles--;
      count++;
    } else {
      target--;
      count++;
    }

    return minMoves(target, maxDoubles);
  }


}
