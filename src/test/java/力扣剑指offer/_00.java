package 力扣剑指offer;

import entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    //04
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) {
             return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]> target || matrix[i][matrix[0].length-1]<target) {
                 continue;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] ==  target) {
                     return  true;
                }
            }
        }
        return  false;
    }

    //05
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    //06
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (Objects.nonNull(head)){
               list.add(head.val);
               head = head.next;
        }
        int[] res =new int[list.size()];
        for (int i = list.size()-1; i>=0; i--) {
             res[i]= list.get(i);
        }
        return res;
    }
}
