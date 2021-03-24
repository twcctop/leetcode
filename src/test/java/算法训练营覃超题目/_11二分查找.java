package 算法训练营覃超题目;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: twc
 * @Date 2021/3/24 14:29
 **/
public class _11二分查找 {

    //x的平方根
    @Test
    public void test69() {
//        System.out.println(mySqrt(17));
        System.out.println(mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        Long head = 0l;
        Long tail = Long.valueOf(x);
        Long res = (head + tail) / 2;
        while (true) {
            if (res * res > x) {
                tail = (head + tail) / 2;
            } else if (res * res < x) {
                head = (head + tail) / 2;
            } else if (res * res == x) {
                return res.intValue();
            }

            if (res == (head + tail) / 2) {
                return res.intValue();
            } else {
                res = (head + tail) / 2;
            }

        }
    }

    // 完全平方数
    @Test
    public void test367() {

    }

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        Long head = 0l;
        Long tail = Long.valueOf(num);
        Long res = (head + tail) / 2;
        while (true) {
            if (res * res > num) {
                tail = (head + tail) / 2;
            } else if (res * res < num) {
                head = (head + tail) / 2;
            } else if (res * res == num) {
//                return  res.intValue();
                return true;
            }

            if ((tail - head == 1) && head * head != num && tail * tail != num) {
                return false;
            } else if (res * res == num) {
                return true;
            } else {
                res = (head + tail) / 2;
            }
        }
    }

    /**
     * @Description
     * @Date 2021/3/24 14:42
     **/
    @Test
    public void test33() {
        int[]  a= {4,5,6,7,0,1,2};
        System.out.println(search(a, 0));
        System.out.println(search(a, 3));
    }

    public int search(int[] nums, int target) {
        int[] sortedNums = new int[nums.length];
        System.arraycopy(nums,0, sortedNums,0,nums.length);
        Arrays.sort(sortedNums);
        //偏移量
        int offset = 0;
        int targetIndex=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sortedNums[0]) {
                offset = i;
                break;
            }
        }
        for (int i = 0; i < sortedNums.length; i++) {
            if (sortedNums[i]==target) {
                targetIndex=i;
                break;
            }
        }
        if (targetIndex==-1) {
             return targetIndex;
        }
         targetIndex= targetIndex+ offset;
        return  targetIndex>=nums.length? targetIndex- nums.length: targetIndex;

    }

    /**
     * @Description  搜索二维矩阵
     * @Date 2021/3/24 15:10
     **/
    @Test
    public void test74() {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return  true;
                }
            }
        }
        return false;
    }

    /**
     * @Description
     * @Date 2021/3/24 15:16
     **/
    @Test
    public void test153() {

    }
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}
