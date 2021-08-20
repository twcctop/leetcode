package leetbook._01_图解算法数据结构;

/**
 * @Author: twc
 * @Date 2021/6/16 12:24
 **/
public class _06查找算法 {

    // 旋转数组最小值
    class Solution11  {
        public int minArray(int[] numbers) {
            for (int i = 1; i < numbers.length; i++) {

                if (numbers[i]<numbers[i-1]) {
                     return numbers[i];
                }
            }
             return  numbers[0];
        }
    }


}
