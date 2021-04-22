package 算法训练营覃超题目;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/4/19 15:37
 **/
public class _13字典树和并查集 {

    /**
     * @Description  实现trie (前缀树）
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



    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(i,j,grid);
                }
            }
        }

        return 0;
    }

    private void dfs(int i, int j, char[][] grid) {

    }

}
