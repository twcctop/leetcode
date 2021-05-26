package 力扣剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: twc
 * @Date 2021/5/21 15:52
 **/
public class offer_02_字符串 {

    //38 字符串的排列  回溯加剪肢
    public String[] permutation(String s) {
        List<String> resList = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<Character>  charList =new ArrayList<>();
        for (char aChar : chars) {
              charList.add(aChar);
        }
        List<Character> curList =  new ArrayList<>();
        dfs38(charList,resList,curList);

        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
             res[i]= resList.get(i);
        }

        return   res;
    }


    //todo  理解错题意了 字符串是可以重复的
    private void dfs38(List<Character> charList, List<String> resList, List<Character> curList) {
        if (charList.size()==curList.size()) {
            StringBuilder builder = new StringBuilder();
            for (Character character : curList) {
                 builder.append(character);
            }
            if (!resList.contains(builder.toString())) {
             resList.add(builder.toString());
            }
            return;
        }

//        List<Character>  newCharList= new ArrayList<>();
//        for (Character character : charList) {
//            if (!curList.contains(character)) {
//                 newCh
//            }
//        }

        for (Character character : charList) {
            List<Character> newList = new ArrayList<>();
            newList.addAll(curList);
            newList.add(character);
            dfs38(charList, resList, newList);
        }

    }


    //39
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return   nums[length/2];
    }

    //40
    public int[] getLeastNumbers(int[] arr, int k) {
          Arrays.sort(arr);
          int[] res= new int[k];
        for (int i = 0; i < k; i++) {
            res[i]= arr[i];
        }
        return  res;
    }
    //41  todo 双堆   list 结构超时
    class MedianFinder {
         List<Integer> list;
        /** initialize your data structure here. */
        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
            if (list.size()%2 ==0) {
                Integer integer = collect.get(collect.size() / 2);
                Integer integer2 = collect.get(collect.size() / 2 -1);
                Double aDouble = Double.valueOf(integer + integer2);
                return aDouble/ (double)2;
            }
            return  collect.get((collect.size()-1)/2);
        }
    }
    //42    连续子数组最大和  dp的题目,怎么搞成滑动窗口了
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max= dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]= Math.max(dp[i-1]+nums[i],nums[i]);
             max= Math.max(dp[i],max);
        }

        return  max;
    }

    //43 todo hard
    public int countDigitOne(int n) {

         return  0;
    }
    //45 todo 找规律
    public int findNthDigit(int n) {
          int count=0;
          int countN = n;
          while ( countN/10 !=0){
                 countN= countN/10;
               count++;
          }

          return 0;
    }
    //46 数字翻译成字符串   !!好题
    //todo 官方题解dp 看不懂
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }

            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25")<= 0 && pre.compareTo("10")>=0) {
                 r+=p;
            }
        }
        return r;
    }
    //todo  dp kgod
    /**
        理解转移方程
     *   dp[i]  = dp[i-1] + dp[i-2]
     *   或者
     *   dp[i] =  dp[i-1]
      */
    /**
     * @Description
     * @Date 2021/5/26 15:35
     **/
    @Test
    public void test25() {
        int i = translateNumKgod(25);
        System.out.println(i);
    }
    public int translateNumKgod(int num) {
        String s = String.valueOf(num);
        int a=1,b=1;
        for (int i = 2; i <= s.length(); i++) {
             String  tmp= s.substring(i-2,i);
             int c=0;
            if (tmp.compareTo("10")>=0  && tmp.compareTo("25")<=0) {
                  c=a+b;
                  a=b;
                  b=c;
            }else{
                c=b;
                a=b;
                b=c;
            }

        }
         return  b;
    }
    //47
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]) + grid[i-1][j-1];
            }
        }
        return dp[row][column];
    }
    //48  todo  "pwwkew" 测试用例无法通过
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max=0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (list.contains(chars[i])) {
                  max= Math.max(max,list.size());
                  list.clear();
            }else {
                 list.add(chars[i]);
            }
        }
        return max;
    }

    //
}
