package 算法训练营覃超题目;

import org.junit.Test;
import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/4/19 15:37
 **/
public class _13字典树和并查集 {

    /**
     * @Description    todo 实现trie (前缀树）
     * @Date 2021/4/19 15:38
     **/
    @Test
    public void test208() {

    }
    class Trie {
        List<String> tree;
        /** Initialize your data structure here. */
        public Trie() {
          tree =  new ArrayList<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
             tree.add(word);

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return  tree.contains(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            for (String s : tree) {
                if (s.startsWith(prefix)) {
                     return  true;
                }
            }
            return  false;
        }
    }


    /**
     * @Description
     * @Date 2021/4/22 18:16
     **/
    @Test
    public void test212() {

    }

    public List<String> findWords(char[][] board, String[] words) {

         return  null;
    }

    /**
     * @Description
     * @Date 2021/4/22 18:31
     **/
    @Test
    public void test200() {
          String demo1=   " [\n" +
                    "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                    "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                    "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                    "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                    "]\n" +
                    "\n";


          String demo2= "[[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"1\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"1\",\"1\"]]";
          String demo3="[[\"1\"],[\"1\"]]";
          String demo4="[[\"1\",\"1\",\"1\"],[\"0\",\"1\",\"0\"],[\"1\",\"1\",\"1\"]]";
//        Character[][] characters = JSON.parseObject(demo1, int);
//        numIslands(characters)
        char[][] chars = ArrayUtil.convertStringCharTwoDimensionArray(demo2);
        ArrayUtil.printTwoDemimalCharArray(chars);
        System.out.println(numIslands(chars));

    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    System.out.println("count++ i,j的值分别为" + i + "  " + j);
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
            return count;
    }

    private void dfs(int r, int c, char[][] grid) {
        if (grid[r][c]=='0') {
            return;
        }
        grid[r][c] = '0';
        int row = grid.length-1;
        int column = grid[0].length-1;
//        System.out.println("i,j的值分别为"+i+"  "+j);
//        ArrayUtil.printTwoDemimalCharArray(grid);
        if ( r+1 >= 0 && r + 1 <=row &&    c >= 0 && c <= column) dfs(r + 1, c, grid);
        if ( r - 1 >= 0 && r - 1 <= row && c >= 0 && c <= column) dfs(r - 1, c, grid);
        if ( r >= 0 && r <= row &&         c + 1 >= 0 && c + 1 <= column) dfs(r, c + 1, grid);
        if ( r >= 0 && r <= row &&         c - 1 >= 0 && c - 1 <= column) dfs(r, c - 1, grid);
    }

    /**
     * @Description
     * @Date 2021/4/23 14:42
     **/
    @Test
    public void test130() {
        String demo1=  " [[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]";
        char[][] chars = ArrayUtil.convertStringCharTwoDimensionArray(demo1);
        int[] flag = new int[1];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                flag=  dfsCheck130(i,j,chars, flag);
                 if (flag[0]==0){
                     dfsChange130(i,j,chars);
                 };
            }
        }
        ArrayUtil.printTwoDemimalCharArray(chars);
    }

    private void dfsChange130(int i, int j, char[][] chars) {
        int row=  chars.length ;
        int colomn = chars[0].length;
        if (chars[i][j]=='X' || i >= row || i < 0 || j >= colomn || j < 0) {
             return;
        }

        chars[i][j] = 'O';

        dfsChange130(i+1,j, chars);
        dfsChange130(i-1,j, chars);
        dfsChange130(i+1,j+1, chars);
        dfsChange130(i+1,j-1, chars);
    }

    private int[] dfsCheck130(int i, int j, char[][] chars, int[] flag) {
        if (flag[0]==1) {
            return flag;
        }
        int row=  chars.length ;
        int colomn = chars[0].length;

        if (i >= row || i < 0 || j >= colomn || j < 0) {
             return flag;
        }

        if (chars[i][j]=='X') {
           return flag;
        }
        if(chars[i][j]=='O'  && (i==0 || i==row-1 || j==0 || j==colomn-1 ) ){
            flag[0]=1;
            return flag;
        }

        chars[i][j]='T';
        if (chars[i][j]!='T') {
            dfsCheck130(i+1,j, chars, flag);
            dfsCheck130(i-1,j, chars, flag);
            dfsCheck130(i+1,j+1, chars, flag);
            dfsCheck130(i+1,j-1, chars, flag);
        }

        return flag;
    }


}
