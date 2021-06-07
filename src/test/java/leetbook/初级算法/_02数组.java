package leetbook.初级算法;

import org.junit.Test;
import util.ArrayUtil;

/**
 * @Author: twc
 * @Date 2021/6/7 11:59
 **/
public class _02数组 {

    /**
     * @Description
     * @Date 2021/6/7 12:06
     **/
    @Test
    public void test() {
        System.out.println(removeDuplicates(ArrayUtil.convertStringIntToArray("[1,1,2]")));
    }
    public int removeDuplicates(int[] nums) {
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[i-1]) {
                 count++;
            }

        }
        return count;
    }
}
