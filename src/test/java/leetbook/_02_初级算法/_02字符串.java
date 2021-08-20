package leetbook._02_初级算法;

import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/18 11:48
 **/
public class _02字符串 {
    //翻转字符串
    public void reverseString(char[] s) {
         int i=0,j=s.length-1;
         while (i<=j){
              char tmp=s[i];
              s[i]=s[j];
              s[j]=tmp;

               i++;
               j--;
         }
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
             map.put(chars[i],i);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])&&  !map.get(chars[i]).equals(i)) {
                 map.remove(chars[i]);
            }
            if (map.containsKey(chars[i])&&  map.get(chars[i]).equals(i)) {
                 return i;
            }
        }
        return  -1;
    }

    //实现strStr()
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
             return 0;
        }
        if (haystack.length()<needle.length()) {
            return  -1;
        }

        char[] hayStackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        for (int i = 0; i < hayStackArr.length; i++) {
            if (hayStackArr[i]== needleArr[0]) {
                for (int j = 0; j < needleArr.length; j++) {
                    if (i+j>=haystack.length()) {
                       return -1;
                    }
                    if (hayStackArr[i+j]!=needleArr[j]) {
                         break;
                    }
                    if (j== needleArr.length-1) {
                        return i;
                    }
                }
            }
        }
        return  -1;
    }

    /**
     * @Description
     * @Date 2021/6/18 14:40
     **/
    @Test
    public void test38() {

        System.out.println(countAndSay(2));
    }

    public String countAndSay(int n) {
        //todo !!!! sb了 应该用stringbuilder 做
        List<Integer> list=new ArrayList<>(n);
        list.add(0);
        list.add(11);
        for (int i = 2; i < n; i++) {
            list.add(getNextCount(i-1));
        }
        return list.get(n-1).toString();

    }
    public  int  getNextCount(int n){
        List<Integer> list = new ArrayList<>();
        while(n!=0){
            list.add(n%10);
            n=n/10;
        }
        Collections.reverse(list);
        int  res= 1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (!list.get(j).equals(list.get(i))) {
                    res= (int)Math.pow(10,String.valueOf(list.get(i)).length()+1) * list.get(i) + res;
                    res= (int)Math.pow(10,String.valueOf(res).length())*(i-j+1) + res;
                }
            }
        }
        return  res;
    }

    /**
     * @Description
     * @Date 2021/6/18 14:59
     **/
    @Test
    public void test() {
        String[] str={"a","ac"};
        longestCommonPrefix( str);
    }

    // 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
             return "";
        }
        if (strs.length==1) {
            return strs[0];
        }
         int count=0;
         while (true){
             for (int i = 1; i < strs.length; i++) {
                 if (strs[i].equals("") || strs[i - 1].equals("")) {
                      return  "";
                 }
                 if (strs[i].length()<=count||strs[i-1].length()<=count) {
                     return  strs[i].substring(0,count);
                 }
                 if (strs[i].charAt(count)!=strs[i-1].charAt(count)) {
                     return  strs[i].substring(0,count);
                 }
             }
             count++;
         }
    }
}
