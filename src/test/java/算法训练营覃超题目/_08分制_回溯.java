package 算法训练营覃超题目;

import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/3/12 18:23
 **/
public class _08分制_回溯 {

    /**
     *  预习
     */

    //快速幂
     @Test
    public void  test50(){

     }

     // 子集
     @Test
     public void test78(){

     }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  res=new ArrayList<>();
        List<Integer>  list = new ArrayList<>();
        int  len  =  nums.length;

        return null;
    }


    /**
     *  homework
     */

    // 多数元素
    @Test
    public void test169(){

    }


    // 电话号码的数字组合
    @Test
    public void test17(){

    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0) {
             return  new ArrayList<>();
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(phoneMap,digits,phoneMap,res);
        return  res;
    }

    public  void backTrack(Map<Character, String> phoneMap, String digits, Map<Character, String> map, List<String> res){
        if (digits=="") {
            return;
        }

        char[]  chars = digits.toCharArray();
        ArrayList  charactrerList = new ArrayList<Character>();
        for (int  i = 0;  i < chars.length;  i++) {
             charactrerList.add(chars[i]);
        }


        if (res.size()==0) {
            char[] chars1 = phoneMap.get(charactrerList.get(0)).toCharArray();
            for (int i = 0; i < chars1.length; i++) {

            }
        }
    }

    /**
     * @Description  n皇后
     * @Date 2021/3/15 16:09
     **/
    @Test
    public void test51() {
    }
    public List<List<String>> solveNQueens(int n) {
      return  null;
    }


}
