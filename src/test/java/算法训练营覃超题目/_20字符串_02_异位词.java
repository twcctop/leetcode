package 算法训练营覃超题目;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/4/30 14:55
 **/
public class _20字符串_02_异位词 {
    /**
     * @Description
     * @Date 2021/4/30 16:23
     **/
    @Test
    public void test438() {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        if (s.equals(p)) {
            return Arrays.asList(0);
        }
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        char[] charsP = p.toCharArray();
        Arrays.sort(charsP);
        String strP = String.valueOf(charsP);
        List<Integer>  list =new ArrayList<>();
        int length = p.length();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (i+ length <= s.toCharArray().length) {
                String substring = s.substring(i, i + length );
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                if (String.valueOf(chars).equals(strP)) {
                    list.add(i);
                }
            }else {
                 break;
            }
        }
        return  list;
    }

}
