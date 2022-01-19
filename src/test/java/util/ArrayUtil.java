package util;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

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
//        System.out.println("遍历整个数组");
        for(int a=0;a<arr.length;a++){//控制每个一维数组
            for(int i=0;i<arr[a].length;i++){//控制每个一维数组中的元素
                System.out.print(arr[a][i]+" ");//输出每个元素的值
            }
            System.out.println();//每执行完一个一维数组换行
        }
    }


    public static  void printTwoDemimalCharArray(char[][] arr){
        System.out.println("遍历整个数组");
        for(int i=0;i<arr.length;i++){//控制每个一维数组
            for(int j=0;j<arr[i].length;j++){//控制每个一维数组中的元素
                System.out.print(arr[i][j]+" ");//输出每个元素的值
            }
            System.out.println();//每执行完一个一维数组换行
        }
    }

    /**
     *  string转换为 二维数组char
     * @param str
     * @return
     */
    public static char[][] convertStringCharTwoDimensionArray(String str){
        Character[][] characters = JSON.parseObject(str, Character[][].class);
        char[][] arr=new char[characters.length][characters[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = characters[i][j];
            }
        }
        return arr;
    }

    /**
     * string 转换为二维int 数组
     * @param str
     * @return
     */
    public static int[][] convertStringTwoDimensionIntArray(String str){
        Integer[][] characters = JSON.parseObject(str, Integer[][].class);
        int[][] arr=new int[characters.length][characters[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = characters[i][j];
            }
        }
        return arr;
    }

    /**
     * string转换为int 数组
     * @param str
     * @return
     */
    public static int[] convertStringIntToArray(String str){
        int[] ints = JSON.parseObject(str, int[].class);
        return ints;
    }

    public static char[] convertStringCharToArray(String str){
        char[] ints = JSON.parseObject(str, char[].class);
        return ints;
    }
    public static String[] convertToStringArray(String str){
        String[] ints = JSON.parseObject(str, String[].class);
        return ints;
    }

    public static void printIntArray(int[] ints1) {
        List list =new ArrayList<>();
        for (int i = 0; i < ints1.length; i++) {
            list.add(ints1[i]);
        }
        System.out.println(list);
    }

    public static void printStringArray(String[] strs) {
        List list =new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        System.out.println(list);
    }




}
