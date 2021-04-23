package test.arr;

import org.junit.Test;

/**
 * @Author: twc
 * @Date 2021/3/17 18:25
 **/
public class testTwoDimensionalArray {
    @Test
    public void testChar() {
        char[][] arr = new char[][]{{1,2,3},{4,5,6},{7,8,9}};
        // 行 列 数
        System.out.println(arr.length);
        System.out.println(arr[0].length);
//        System.out.println(new String(String.valueOf(arr)));
        // 遍历元素
/*        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]+" ");
//                if (Objects.isNull(arr[i][j])||arr[i][j]==0) {
//                    System.out.print("test");
//                } else {
//                    System.out.print(arr[i][j]);
//                }
            }*/


            for(int a=0;a<arr.length;a++){//控制每个一维数组
                for(int i=0;i<arr[a].length;i++){//控制每个一维数组中的元素
                    // todo  char中值存的是int类型 导致失效
                    char c = arr[a][i];
                    String s= String.valueOf(c);
                    System.out.println(s +" ");
                }
                System.out.println();//每执行完一个一维数组换行
            }
            System.out.println();
        }

    @Test
    public void testTwoDecimal(){
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        // 遍历第一个一维数组
        for(int i=0;i<arr[0].length;i++){
            System.out.print(arr[0][i]+" ");
        }
        System.out.println();

        System.out.println("遍历整个数组");
        for(int a=0;a<arr.length;a++){//控制每个一维数组
            for(int i=0;i<arr[a].length;i++){//控制每个一维数组中的元素
                System.out.print(arr[a][i]+" ");//输出每个元素的值
            }
            System.out.println();//每执行完一个一维数组换行
        }
    }
}
