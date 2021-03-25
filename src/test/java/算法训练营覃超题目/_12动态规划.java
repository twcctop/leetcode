package 算法训练营覃超题目;

import org.junit.Test;

/**
 * @Author: twc
 * @Date 2021/3/24 14:39
 **/
public class _12动态规划 {

    /**
     * @Description
     * @Date 2021/3/24 15:23
     **/
    @Test
    public void test1143() {
//        System.out.println(longestCommonSubsequence("abcde", "ace"));
//        System.out.println(longestCommonSubsequence("abc", "abc"));
//        System.out.println(longestCommonSubsequence("abc", "def"));
//        System.out.println(longestCommonSubsequence("bl", "yby"));
//        System.out.println(longestCommonSubsequence("psmw", "vozsh"));
        //  "oxcpqrsvwf"
        //"shmtulqrypy"   ??????????为什么不符合
        System.out.println(longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length()<text2.length()) {
              String temp=text1;
              text1=text2;
              text2=temp;

        }
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        int j=0;
        int count=0;
        for (int i = 0; i < charArray1.length; i++) {
            for (int k = j; k < charArray2.length; k++) {
                if (charArray1[i] == charArray2[k]) {
                    count++;
                    j= k;
                }
            }
        }
        return  count;

    }


}
