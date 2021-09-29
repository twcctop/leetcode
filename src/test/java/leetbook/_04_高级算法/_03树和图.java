package leetbook._04_高级算法;

import entity.TreeNode;

import java.util.List;

public class _03树和图 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        return  0;

    }
    //被围绕的区域
    public void solve(char[][] board) {

    }
    //二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return  null;
    }

    // 二叉树的最大路径和 ,
    public int maxPathSum(TreeNode root) {
        if (root== null) {
             return  0;
        }
        return  Math.max(maxPathSum(root.left),maxPathSum(root.right))+ root.val;
    }


    // 朋友圈
    public int findCircleNum(int[][] isConnected) {

        return  0;
    }
    // 课程表 错误 ， 有向无环图
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count =0 ;
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = i+1; j < prerequisites.length; j++) {
                if (prerequisites[i][j]!= prerequisites[j][i]) {
                     count++;
                }

            }
        }
        return  count>= numCourses;
    }

    // 矩阵中的最长递增, 记忆化搜索加排序
    public int longestIncreasingPath(int[][] matrix) {
        int[][]  cache=new int[matrix.length][matrix[0].length];
        int max=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
//                 dfs[i,j,matrix,backup,0];
                max= Math.max(max,dfs(matrix,cache, i,j));
            }
        }
        return  0;
    }
// https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
    // 看不懂
    private int dfs(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) {
            return  cache[i][j];
        }
        if (i+1 <= matrix.length &&  matrix[i+1][j]> matrix[i][j] ) {
//             upVal = dfs(matrix, cache, i + 1, j);
        }
        if (i-1 >0 &&  matrix[i+1][j]> matrix[i][j] ) {
            int downVal = dfs(matrix, cache, i - 1, j);
        }
        if (j+1 <= matrix[0].length &&  matrix[i+1][j]> matrix[i][j] ) {
            int lfetVal = dfs(matrix, cache, i , j);
        }
        if (i-1 >0  &&  matrix[i+1][j]> matrix[i][j] ) {
            int  rightVal = dfs(matrix, cache, i + 1, j);
        }
        return  0;

    }

    // 右侧小于当前元素的个数
    // 离散算法？
    public List<Integer> countSmaller(int[] nums) {

        return  null;

    }



}
