package leetcode周赛.n276;

import org.junit.Test;

public class p3 {
  /**
   * @Description
   * @Date 2022/1/16 11:35
   **/
  @Test
  public void test3() {

  }

  int maxPoint = 0;

  public long mostPoints(int[][] questions) {
    return getMaxPoints(questions, 0);
  }

  private long getMaxPoints(int[][] questions, int currentPoint) {
    if (questions.length == 0) {
      maxPoint = Math.max(currentPoint, maxPoint);
      return maxPoint;
    }

    int[][] subArray = getSubArray(questions, 1);
    getMaxPoints(subArray, currentPoint);

    int[] question = questions[0];
    currentPoint = currentPoint + question[0];
    int[][] subArray2 = getSubArray(questions, question[1] + 1);
    getMaxPoints(subArray2, currentPoint);
    return maxPoint;
  }

  private int[][] getSubArray(int[][] questions, int i) {
    if (questions.length < i) {
      return new int[0][0];
    }
    int[][] res = new int[questions.length - i][2];
    int cur = 0;
    for (int j = i; j < questions.length; j++) {

      res[cur] = questions[j];
      cur++;
    }
    return res;
  }


  /**
   * @Description
   * @Date 2022/1/16 11:41
   *
   *  10 10 3 5  3
   **/
  @Test
  public void test3_2() {
  }



  public long mostPointsOfficial(int[][] questions) {
    int length = questions.length;
    int[] f = new int[length + 1];

    f[length+1] =0;

    for (int i = length; i >= 0; i--) {
      int[] question = questions[i];
       int score =i+question[1]+ 1;




    }





    return 0;
  }
}
