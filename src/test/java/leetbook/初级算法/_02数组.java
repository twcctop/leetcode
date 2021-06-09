package leetbook.初级算法;

import com.sun.javafx.logging.JFRInputEvent;
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
    public int removeDuplicates(int[] nums){
        int slow=0;
        for (int i = 0; i < nums.length; i++) {
            if (i==0) {
                slow++;
                continue;
            }
            if (nums[i]==nums[i-1]) {
                continue;
            }else {
                nums[slow]=nums[i];
                slow++;
            }
        }
        return  slow;
    }

    public int maxProfit(int[] prices) {
         return  0;
    }
}
