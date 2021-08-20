package leetbook.中级算法;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/22 17:23
 **/
public class _02数组和字符串 {


    //todo 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();

        return  null;
    }

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        Set<Integer> rowList = new HashSet<>();
        Set<Integer> columnList = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    columnList.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rowList.contains(i) || columnList.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //无重复字符的最长子串
    // todo 总是报错
    /**
     * @Description
     * @Date 2021/6/24 18:00
     **/
    @Test
    public void test32() {
//        System.out.println(lengthOfLongestSubstring("abba")); //2
        System.out.println(lengthOfLongestSubstring("pwwkew"));  //3
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
             return  0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int res=0;
        int cur=0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (i-map.get(chars[i])<cur) {
                    map.put(chars[i],i);
                     cur++;
                     continue;
                }else {
                    map.put(chars[i],i);
                  res=Math.max(res,cur);
                  cur=0;
                  continue;
                }
            }
            cur++;
            res=Math.max(res,cur);
            map.put(chars[i],i);
        }
        return res;

    }

    //最长回文子串  todo 看答案的
    public String longestPalindrome(String s){
        //
        return  "";

    }

    //递增的三元子序列
    public boolean increasingTriplet(int[] nums) {
        return  true;
    }


}
