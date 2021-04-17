package util;

/**
 * @Author: twc
 * @Date 2021/4/17 23:43
 **/
public class ArrayUtil {

    /**
     * 遍历二维int 数组
     * @param arr
     */
    public static  void printTwoDemimalIntArray(int[][] arr){
        System.out.println("遍历整个数组");
        for(int a=0;a<arr.length;a++){//控制每个一维数组
            for(int i=0;i<arr[a].length;i++){//控制每个一维数组中的元素
                System.out.print(arr[a][i]+" ");//输出每个元素的值
            }
            System.out.println();//每执行完一个一维数组换行
        }
    }

}
