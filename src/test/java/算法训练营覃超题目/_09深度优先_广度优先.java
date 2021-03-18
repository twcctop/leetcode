package 算法训练营覃超题目;

import entity.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/3/15 11:31
 **/
public class _09深度优先_广度优先 {
    /**
     * @Description 二叉树的层序遍历
     * @Date 2021/3/15 16:18
     **/
    @Test
    public void test102() {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);
        System.out.println(levelOrder(node3));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Integer curLevel = 0;
        levelOrderRecuration(root, map, curLevel);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private void levelOrderRecuration(TreeNode root, Map<Integer, List<Integer>> map, int curLevel) {
        if (root == null) {
            return;
        }
        // 添加跟数值
        List<Integer> integerList = new ArrayList<>();
        if (map.containsKey(curLevel)) {
            integerList = map.get(curLevel);
        }

        integerList.add(root.val);
        map.put(curLevel, integerList);

        //左右
        if (root.left != null) {
            levelOrderRecuration(root.left, map, curLevel + 1);
        }
        if (root.right != null) {
            levelOrderRecuration(root.right, map, curLevel + 1);
        }
    }

    /**
     * @Description 最小基因变化
     * @Date 2021/3/16 9:53
     **/
    @Test
    public void test433() {
    }

    public int minMutation(String start, String end, String[] bank) {
        return 0;
    }

    /**
     * @Description 括号生成
     * @Date 2021/3/16 10:13
     **/
    @Test
    public void test22() {
        System.out.println(generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        int max = 2 * n;
        List<String> res = new ArrayList<>();
        generate(res, n, new StringBuilder(), max);
        return res;
    }

    private void generate(List<String> res, int n, StringBuilder stringBuilder, int max) {
        if (max == 0) {
            res.add(stringBuilder.toString());
            return;
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append('(');
            generate(res, n, stringBuilder, max - 1);
            return;
        }
        int leftcount = 0, rightcount = 0;
        char[] chars = stringBuilder.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                leftcount++;
            } else {
                rightcount++;
            }
        }
        // 限制条件
        if (leftcount == n) {
            stringBuilder.append(')');
            generate(res, n, stringBuilder, max - 1);
            return;
        }

        if (0 <= leftcount && leftcount < n && 0 <= rightcount && rightcount < n && leftcount >= rightcount) {
            StringBuilder leftBuilder = stringBuilder;
            StringBuilder rightBuilder = stringBuilder;

            leftBuilder.append('(');
            generate(res, n, leftBuilder, max - 1);


            // rightbuilder的值会随着string builder 变化
            // 回退
            rightBuilder.append(')');
            generate(res, n, rightBuilder, max - 1);
            return;
        }
    }

    /**
     * @Description 每个树行中找最大值
     * @Date 2021/3/16 15:21
     **/
    @Test
    public void test() {

    }

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Integer curLevel = 0;
        levelOrderRecuration(root, map, curLevel);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        List<Integer> integerRes = new ArrayList<>();
        for (List<Integer> re : res) {
            integerRes.add(Collections.max(re));
        }
        return integerRes;
    }

    /**
     * @Description 单词接龙
     * @Date 2021/3/16 15:32
     **/
    @Test
    public void test127() {
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

    /**
     * @Description 岛屿数量   很经典的可以用dfs 和bfs  解决的问题
     * @Date 2021/3/17 18:02
     **/
    @Test
    public void test200() {


    }

    public int numIslands(char[][] grid) {
        if (grid==null || grid.length== 0) {
             return  0;
        }
        int nr=grid.length;
        int nc=grid[0].length;
        int res= 0;
        for (int i = 0; i < nr; i++) {
            for (int i1 = 0; i1 < nc; i1++) {
                if (grid[i][i1] =='1') {
                    res++;
                    dfs200(grid,i,i1);
                }
            }
        }

        return res;
    }
    //深度优先
    private void dfs200(char[][] grid, int r, int c) {
          int nr=grid.length;
          int nc=grid[0].length;

        if ( r>=nr ||r<0  || c>=nc || c<0    || grid[r][c] =='0') {
             return;
        }
        grid[r][c]='0';
        dfs200(grid,r+1,c);
        dfs200(grid,r-1,c);
        dfs200(grid,r,c+1);
        dfs200(grid,r,c-1);
    }

    public int numIslandsbfs(char[][] grid) {
        if (grid==null||grid.length==0) {
             return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands= 0;

        for (int  r = 0;  r < nr;  r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    num_islands++;
                    grid[r][c] ='0';
                    Queue<Integer> neighbors =  new LinkedList<>();
                    //
                    neighbors.add(r*nc +c);
                    while (!neighbors.isEmpty()){
                        while (!neighbors.isEmpty()) {
                             int id = neighbors.remove();
                             int row = id/nc;
                             int col = id%nc;

                            if (row - 1 >= 0 && grid[row-1][col] == '1') {
                                neighbors.add((row-1) * nc + col);
                                grid[row-1][col] = '0';
                            }
                            if (row + 1 < nr && grid[row+1][col] == '1') {
                                neighbors.add((row+1) * nc + col);
                                grid[row+1][col] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col-1] == '1') {
                                neighbors.add(row * nc + col-1);
                                grid[row][col-1] = '0';
                            }
                            if (col + 1 < nc && grid[row][col+1] == '1') {
                                neighbors.add(row * nc + col+1);
                                grid[row][col+1] = '0';
                            }

                        }
                    }
                }
            }

        }

        return  num_islands;

    }


    /**
     * @Description 扫雷游戏
     * @Date 2021/3/18   **/
    @Test
    public void test529() {
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        return null;
    }
}
