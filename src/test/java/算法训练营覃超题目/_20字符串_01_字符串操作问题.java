package 算法训练营覃超题目;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author: twc
 * @Date 2021/4/19 15:34
 **/
public class _20字符串_01_字符串操作问题 {
    /**
     * @Description
     * @Date 2021/4/30 15:01
     **/
    @Test
    public void test709() {

    }
    public String toLowerCase(String str) {
        return  str.toLowerCase();
    }

    /**
     * @Description
     * @Date 2021/4/30 15:06
     **/
    @Test
    public void test() {
        System.out.println(lengthOfLastWord("     "));
    }

    public int lengthOfLastWord(String s) {
        if (s.equals(" ")) {
            return  0;
        }
        if (!s.contains(" ")) {
              return  s.length();
        }else  {
            String[] s1 = s.split(" ");
            if (s1.length==0) {
                return  0;
            }
            return  s1[s1.length-1].length();
        }
    }

    /**
     * @Description
     * @Date 2021/4/30 15:26
     **/
    @Test
    public void test771() {
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count =0;
        List<Character>  jewelsList = new ArrayList<>();
        for (char c : jewels.toCharArray()) {
            jewelsList.add(c);
        }
        for (char c : stones.toCharArray()) {
            if (jewelsList.contains(c)) {
                 count++;
            }
        }
        return  count;
    }

    /**
     * @Description
     * @Date 2021/4/30 15:40
     **/
    @Test
    public void test387() {
        System.out.println(firstUniqChar2("leetcode"));
        System.out.println(firstUniqChar2("loveleetcode"));
        System.out.println(firstUniqChar2("aabb"));
    }

    // 超时
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch  = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.get(s.charAt(i)).intValue() ==1) {
                return  i;
            }
        }
        return  -1;
    }
    // 超时
    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.toCharArray().length; i++) {
            String c = String.valueOf(s.charAt(i));
            String substring = s.substring(0,i)+  s.substring(i+1, s.toCharArray().length);
            if (!substring.contains(c)) {
                 return  i;
            }
        }
        return  -1;
    }


    /**
     * @Description
     * @Date 2021/4/30 15:55
     **/
    @Test
    public void test8() {

    }
}
