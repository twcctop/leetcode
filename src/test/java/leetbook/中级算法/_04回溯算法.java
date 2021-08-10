package leetbook.中级算法;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/26 20:04
 **/
public class _04回溯算法 {

     // 电话号码和字母的组合
    /**
     *@Description
     *@Date 2021/8/6 22:59
    **/
    class Solution{
        Map<Character,List<Character>> map = new HashMap<>();
        public Solution(Map<Character, List<Character>> map) {
            this.map = map;
            map.put('2', Arrays.asList('a','b','c'));
            map.put('3', Arrays.asList('d','e','f'));
            map.put('4', Arrays.asList('g','h','l'));
        }
        List<String> res= new ArrayList<>();


        public List<String> letterCombinations(String digits) {
            dfs(digits,new StringBuilder());
            return  res;
        }

        private void dfs(String digits, StringBuilder stringBuilder) {
            if (digits.isEmpty()) {
                if (stringBuilder.toString().isEmpty()) {
                     return;
                }else {
                     res.add(stringBuilder.toString());
                }
            }
            char c = digits.charAt(0);
            List<Character> characters = map.get(c);
            for (Character character : characters) {
                StringBuilder sb2 =stringBuilder;
                dfs(digits.substring(1), sb2.append(character));
            }

        }
    }

    //全排列
    public List<List<Integer>> permute(int[] nums) {

        return null;
    }

    //子集
    public List<List<Integer>> subsets(int[] nums) {

        return null;
    }

    //单词搜索
    public boolean exist(char[][] board, String word) {

        return true;
    }



}
