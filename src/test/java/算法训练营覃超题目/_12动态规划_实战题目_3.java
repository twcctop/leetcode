package 算法训练营覃超题目;

import org.junit.Test;

/**
 * @Author: twc
 * @Date 2021/3/27 15:08
 **/
public class _12动态规划_实战题目_3 {
    /**
     * @Description  完全平方数
     * @Date 2021/4/9 23:39
     **/
    @Test
    public void test279() {

    }

    public int numSquares(int n) {
      return  0;
    }


    //55
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                break;
            }
            max = Math.max(max, nums[i] + i);
        }
        return max >= nums.length-1;
    }

    //45
    //不想写了
    public int jump(int[] nums) {
         int max=0;
         int i=0;
         while(max<nums.length-1){
             for (int j = 0; j < i+nums[i]; j++) {
                   max= Math.max(max,j+nums[j+i]);

             }
         }
         return 0;
    }
}
