package 算法训练营覃超题目._16_位运算;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/4/23 15:48
 **/
public class _16位运算 {


    @Test
    public void test191() {
        //   idea debug得知  读取成8进制的，很怪异
        System.out.println(hammingWeight(00000000000000000000000000001011));
//        System.out.println(hammingWeight(1011));
//        System.out.println(hammingWeight(00000000000000000000000000000010));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int a = n >> i;
            int b = a & 1;
            if (b == 1) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test50() {
//         System.out.println(quickMul(2.0, -2147483648));
        System.out.println(myPow(2.0, -2147483648));
        System.out.println(myPow(2.0, -4));

    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);

    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
//        if(N<0) {
//            x=1/x;
//            N=-N;
//        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    @Test
    public void test78(){
        // 测试移位运算符
        System.out.println(1 << 4);
        int[] a={2,5,9};
        System.out.println(subsets(a));
    }
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        for (int mask = 0; mask < 1<<n; mask++) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return  ans;
    }

}
