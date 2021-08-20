package leetbook._01_图解算法数据结构;

/**
 * @Author: twc
 * @Date 2021/6/16 16:49
 **/
public class _08位运算 {


    //二进制中1的个数
    public int hammingWeight(int n) {
             int res=0;
             while(n!=0){
                  res+=res&1;
                  n>>>=1;
             }
             return res;
    }

    // 数字出现的次数
    public int[] singleNumbers(int[] nums) {
         return  new int[1];
    }
}
