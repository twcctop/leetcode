package 算法训练营覃超题目;

import org.junit.Test;
import util.ArrayUtil;

/**
 * @Author: twc
 * @Date 2021/3/27 15:08
 **/
public class _12动态规划_实战题目_homework {

    /**
     * @Description 最长有效括号
     * @Date 2021/4/27 17:00
     **/
    @Test
    public void test32() {
        String s="(()))";
        System.out.println(longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1)== '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if( i-dp[i-1] >0 && s.charAt(i- dp[i-1]-1) =='('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }

                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * @Description  最小路径和
     * @Date 2021/4/27 17:28
     **/
    @Test
    public void test64() {
        String s= "[[1,3,1],[1,5,1],[4,2,1]]";
        System.out.println(minPathSum(ArrayUtil.convertStringTwoDimensionIntArray(s)));
    }
    public int minPathSum(int[][] grid) {
        // 第一行
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] = grid[0][j] +grid[0][j-1];
        }
        // 第一列
        for (int i = 1; i < grid.length; i++) {
            grid[i][0]= grid[i][0] + grid[i-1][0];
        }
        //剩余
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }

        return  grid[grid.length-1][grid[0].length-1] ;

    }

    /**
     * @Description 编辑距离
     * @Date 2021/4/27 18:55
     **/
    @Test
    public void test72() {
        String word1= "intention";
        String word2= "execution";
        System.out.println(minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        for (int  i = 0;  i < word2.length()+1;  i++) {
             dp[i][0] =  i;
        }
        for (int  j = 1;  j < word1.length()+1;  j++) {
            dp[0][j] =  j;
        }
        for (int i = 1; i < word2.length() + 1; i++) {
            for (int j = 1; j < word1.length() + 1; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                dp[i][j] = min + 1;
            }
        }

        return dp[word2.length()][word1.length()];
    }

    /**
     * @Description 解码方法
     * @Date 2021/4/28 10:31
     **/
    @Test
    public void test91() {
    }
    public int numDecodings(String s) {

        return 0;
    }

    /**
     * @Description
     * @Date 2021/4/28 11:28
     **/
    @Test
    public void test221() {

    }

    public int maximalSquare(char[][] matrix) {
         int row = matrix.length;
         int column= matrix[0].length;
         int[][] dp =new int[row+1][column+1];
         int maxlen= 0;
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                if (matrix[i-1][j-1] =='1') {
                     dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                     maxlen = Math.max(dp[i][j],maxlen);
                }
            }
        }
         return  maxlen*maxlen;
    }

    /**
     * @Description  不大于某值的最大矩阵和

     * @Date 2021/4/28 17:34
     **/
    @Test
    public void test363() {
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
         return 0;
    }

    /**
     * @Description  青蛙过河
     * @Date 2021/4/28 17:41
     **/
    @Test
    public void test403() {
    }
    public boolean canCross(int[] stones) {

        return true;
    }


}
