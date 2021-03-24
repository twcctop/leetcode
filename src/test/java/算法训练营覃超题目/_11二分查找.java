package 算法训练营覃超题目;

import org.junit.Test;

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
}
