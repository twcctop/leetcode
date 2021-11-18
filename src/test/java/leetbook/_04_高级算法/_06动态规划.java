package leetbook._04_高级算法;

import org.junit.Test;
import 力扣剑指offer_第一遍刷._offer_01_二叉树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _06动态规划 {


    //完全平方数
    public int numSquares(int n) {

        return  0;
    }

    /**
     * @Description  单词拆分
     * @Date 2021/11/18 15:50
     **/
    @Test
    public void test1() {

        List<String> list =new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode", list));
    }
    @Test
    public void test2() {

        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(wordBreak("ab", list));
    }

    @Test
    public void test3() {

        List<String> list =new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        System.out.println(wordBreak("aaaaaaa", list));
    }


    //单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (set.contains(substring)) {
                    if (j==s.length()) {
                         return  true;
                    }
                     i=j;
                     j=i;
                }
            }
        }
        return  false;
    }



    //戳气球  根本看不懂

    public int maxCoins(int[] nums) {


         return  0;
    }
}
