package leetbook.中级算法;

import org.junit.Test;
import util.ArrayUtil;

import java.util.Arrays;

/**
 * @Author: twc
 * @Date 2021/6/26 20:04
 **/
public class _06排序和搜索 {


    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    // 第k个最大元素
    public int findKthLargest(int[] nums, int k) {

        return  0;
    }
    // 前k个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        return  null;

    }

    /**
     * @Description  排序数组
     * @Date 2021/8/10 17:09
     **/
    @Test
    public void test912() {
    }


    /**
     *@Description     912对数组进行排序
     *@Date 2021/8/10 17:50
     * 1.菜鸟教程快排
     *  https://www.runoob.com/w3cnote/quick-sort-2.html
    **/

    @Test
    public void test() {
        int[] ints = ArrayUtil.convertStringIntToArray("[5,2,3,1]");
        Solution912 s= new Solution912();
        ArrayUtil.printIntArray(s.sort(ints));
    }
    class Solution912 {

        /**
         * @Description
         * @Date 2021/8/11 10:29
         **/

         public int[] sort(int[] nums){
             int[] arr= Arrays.copyOf(nums,nums.length);
             return quickSort(arr,0,arr.length-1);
         }

        private int[] quickSort(int[] arr, int left, int right) {
              if(left<right){
                   int partitionIndex = partition(arr,left,right);
                   quickSort(arr,left,partitionIndex-1);
                   quickSort(arr,partitionIndex+1,right);
              }
             return arr;
        }

        private int partition(int[] arr, int left, int right) {
            //设定基准值 (pivot)
            int pivot = left;
            int index = pivot + 1;
            for (int i = index; i <= right; i++) {
                if (arr[i] < arr[pivot]) {
                    swap(arr, i, index);
                    index++;
                }
            }
            swap(arr, pivot, index - 1);
            return index - 1;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // todo  快速排序算法
    /**
     *@Description  数组中的第K大元素
     *@Date 2021/8/11 10:39
     *
    **/
    class Solution215{
        public int findKthLargest(int[] nums, int k) {
          int[] arr=  quickSort(nums,0,nums.length-1);
          return  arr[nums.length-k];
        }

        private int[] quickSort(int[] nums, int left, int right) {
            if (left < right) {
                 int partitionsIndex= partition(nums,left,right);
                 quickSort(nums,left,partitionsIndex-1);
                 quickSort(nums,partitionsIndex+1,right);
            }
            return  nums;
        }

        private int partition(int[] nums, int left, int right) {
              //  还是无法理解
             return 0;
        }
    }

    // 寻找峰值


    //排序数组找第一个和最后一个

    //合并区间

}
