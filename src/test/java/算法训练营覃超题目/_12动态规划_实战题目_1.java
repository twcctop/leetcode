package 算法训练营覃超题目;

import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/3/24 14:39
 **/
public class _12动态规划_实战题目_1 {

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
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;

        }
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        int j = 0;
        int count = 0;
        for (int i = 0; i < charArray1.length; i++) {
            for (int k = j; k < charArray2.length; k++) {
                if (charArray1[i] == charArray2[k]) {
                    count++;
                    j = k;
                }
            }
        }
        return count;
    }

    /**
     * @Description 爬楼梯
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
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6, 5, 7));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        System.out.println(minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        // 定义n行m列的二维数组
        int[][] dp = new int[n][m];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++) {
                if (j - 1 < 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        //取出最后一列的最小值
        int[] resArray = dp[n - 1];
        Arrays.sort(resArray);
        return resArray[0];
    }


    /**
     * @Description
     * @Date 2021/3/27 11:07
     **/
    @Test
    public void test53() {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] b = {1, 2};
        int[] c = {-2, 1};
        int[] d = {-2, -1};
//        System.out.println(maxSubArray(a));
//        System.out.println(maxSubArray(b));
//        System.out.println(maxSubArray(c));
//        System.out.println(maxSubArray(d));

        System.out.println(maxSubArrayDp(a));
        System.out.println(maxSubArrayDp(b));
        System.out.println(maxSubArrayDp(c));
        System.out.println(maxSubArrayDp(d));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int cur = getSum(i, j, nums);
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    private int getSum(int i, int j, int[] nums) {
        if (i == j) {
            return nums[j];
        }
        int res = 0;
        for (int k = i; k <= j; k++) {
            res += nums[k];
        }
        return res;
    }


    public int maxSubArrayDp(int[] nums) {
        // -2,1,-3,4,-1,2,1,-5,4
        int max = nums[0];
        // 若前一个元素大于0， 则将其加到当前元素上
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /**
     * @Description
     * @Date 2021/3/27 11:56
     **/
    @Test
    public void test152() {
        int[] a = {-2, 0, 1};
        int[] b = {2, -5, -2, -4, 3};
        int[] c = {-1, -2, -3};
//        System.out.println(maxProduct(a));
//        System.out.println(maxProduct(b));
        System.out.println(maxProduct(c));
    }

    public int maxProduct(int[] nums) {
        return  getMax(nums);
    }

   public int  getMax(int[] nums){


       int[] subNums = new int[nums.length];
       int[] subNums2 = new int[nums.length];
       System.arraycopy(nums, 0, subNums, 0, nums.length);
       System.arraycopy(nums, 0, subNums2, 0, nums.length);
       int max = nums[0];
       int flag = 0;


       for (int i = 1; i < nums.length; i++) {
           if (nums[0] < 0 && flag==0 || nums[i] < 0 && flag == 0) {
               flag = 1;
               if (nums[0] <= 0) {
                   subNums2[0] = 0;
               } else {
                   subNums2[i] = 0;
               }
           }
           if (subNums2[i - 1] != 0) {
               subNums2[i] = subNums2[i] * subNums2[i - 1];
           }

           if (subNums[i - 1] != 0) {
               subNums[i] = subNums[i] * subNums[i - 1];
           }

           if (nums[i - 1] > 0 && nums[i] > 0) {
               nums[i] = nums[i] * nums[i - 1];
           }

           max = Math.max(Math.max(max, subNums[i]), nums[i]);
           max = Math.max(max, subNums2[i]);
       }
       return max;

    }

    public int maxProductAns(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }


    /**
     * @Description 零钱兑换
     * @Date 2021/3/27 14:46
     **/
    @Test
    public void test322() {
         int[] a={ 1,2,5};
        System.out.println(coinChange(a, 0));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count=0;
        for (int i = coins.length-1; i >=0; i--) {
             while(amount>= coins[i]){
                  amount-=  coins[i];
                  count++;
             }
        }
        return amount==0? count:-1;
    }




}
