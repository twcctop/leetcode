package 算法训练营覃超题目;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    /**
     * @Description  爬楼梯
     * @Date 2021/3/25 11:16
     **/
    @Test
    public void test70() {
    }

    /**
     * @Description 三角形最小路径和
     * @Date 2021/3/25 11:19
     **/
    @Test
    public void test120() {
        List<Integer>  list1= new ArrayList<>(Arrays.asList(2));
        List<Integer>  list2= new ArrayList<>(Arrays.asList(3,4));
        List<Integer>  list3= new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer>  list4= new ArrayList<>(Arrays.asList(4,1,8,3));
        List<List<Integer>> triangle  = new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        System.out.println(minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
            int n= triangle.size();
            int m =  triangle.get(n-1).size();
            // 定义n行m列的二维数组
            int[][] dp= new int[n][m];
            dp[0][0] =triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            int size = triangle.get(i).size();
            for (int  j = 0;  j < size;  j++) {
                if (j-1<0) {
                    dp[i][j]= triangle.get(i).get(j)+ dp[i-1][j];
                }else {
                    dp[i][j]= triangle.get(i).get(j) + Math.min( dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        //取出最后一列的最小值
        int[] resArray = dp[n - 1];
        Arrays.sort(resArray);
         return  resArray[0];
    }
}
