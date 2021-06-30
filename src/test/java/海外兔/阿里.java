package 海外兔;

import org.junit.Test;
import util.ArrayUtil;

/**
 * @Author: twc
 * @Date 2021/6/30 21:21
 **/
public class 阿里 {
//    10亿个数中如何高效地找到最大的一个数以及最大的第 K 个数  困难 参考1


//   两个 10G 大小包含 URL 数据的文件，最多使用 1G 内存，将这两个文件合并，并找到相同的 URL  困难


    //排序数组
    // 1.插入排序

    /**
     * @Description
     * @Date 2021/6/30 21:52
     **/
    @Test
    public void test24() {
        int[] ints = ArrayUtil.convertStringIntToArray("[5,2,3,1]");
        int[] ints1 = sortArrayInsert(ints);
         ArrayUtil.printIntArray(ints1);
    }
    public int[] sortArrayInsert(int[] nums) {
          int len= nums.length;
          //循环不变量 : 将nums[i]  f
        for (int i = 1; i < len; i++) {
            int temp=nums[i];
            int j=i;
            while(j>0&&  nums[j-i]>temp){
                 nums[j]= nums[j-1];
                 j--;
            }
            nums[j]= temp;
        }
        return nums;

    }


//如何随机生成不重复的 10 个 100 以内的数字


    //random7
//    public int rand10() {
//        int num = (rand7() - 1) * 7 + rand7();
//
//    }

}
