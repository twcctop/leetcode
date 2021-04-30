package 力扣剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/4/30 17:08
 **/
public class _00 {
    /**
     * @Description   剑指offer 03:数组中重复的数字   todo   超时？
     * @Dat
     * 30 17:08
     **/
    @Test
    public void test03() {


    }
    public int findRepeatNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                return  num;
            }
             list.add(num);
        }
        return  -1;
    }
}
