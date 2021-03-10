package 算法训练营覃超题目;

import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/3/10 17:09
 **/
public class _05哈希表_映射_集合 {

    // 有效的字母异位词
    @Test
    public void test242() {
        System.out.println(isAnagram("anagram",
                "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //
    @Test
    public void test49() {
        String[] args = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(args));
        ;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.containsKey(s)) {
                List<String> strings = map.get(s);
                strings.add(str);
                map.put(s, strings);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(s, list);
            }
        }

        List<List<String>> res = new LinkedList<List<String>>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            res.add(value);

        }
        return res;
    }

     @Test
     public void test1(){

     }


}
