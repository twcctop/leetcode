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
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int  i = 0;  i < word1.length()+1;  i++) {
             dp[1]

        }

    }


}
