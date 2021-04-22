package 算法训练营覃超题目;

import org.junit.Test;
import org.omg.CORBA.ARG_IN;
import util.ArrayUtil;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: twc
 * @Date 2021/4/9 23:47
 **/
public class _18排序算法 {

    /**
     * @Description 数组的相对排序
     * @Date 2021/4/9 23:48
     **/
    @Test
    public void test1122() {
//        int[]  arr1 = {2,3,1,3,2,4,6,7,9,2,19};
//        int[]  arr2= {2,1,4,3,9,6};
//        System.out.println(Arrays.stream(relativeSortArray(arr1, arr2)).boxed().collect(Collectors.toList()));

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.stream(relativeSortArray(arr1, arr2)).boxed().collect(Collectors.toList()));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        List<Integer> arr2List = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        List<Integer> arr2ListNotRemove = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        List<Integer> notCollect = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr2List.contains(arr1[i])) {
                //
                for (int j : arr1) {
                    if (j == arr1[i]) {
                        res[flag] = arr1[i];
                        flag++;
                    }
                }
                for (int k = 0; k < arr2List.size(); k++) {
                    if (arr2List.get(k) == arr1[i]) {
                        arr2List.remove(k);
                    }
                }
            } else {
                if (!arr2ListNotRemove.contains(arr1[i])) {
                    notCollect.add(arr1[i]);
                }
            }
        }
        for (Integer integer : notCollect) {
            res[flag] = integer;
            flag++;
        }
        return res;
    }

    /**
     * @Description
     * @Date 2021/4/17 22:30
     **/
    @Test
    public void test242() {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return new String(charsS).equals(new String(charsT));
    }

    /**
     * @Description
     * @Date 2021/4/17 22:48
     **/
    @Test
    public void test56() {

        int[][]  inter = {{1,3},{2,6},{8,10},{15,18}};
        ArrayUtil.printTwoDemimalIntArray(merge(inter));
    }

    public int[][] merge(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                if (!list.contains(intervals[i][j])) {
                    list.add(intervals[i][j]);
                }
            }
        }
        Collections.sort(list);
        int start = 0;
        int end = 0;

        List<int[]> res = new ArrayList<>();
        //list 间断的转为 arr  123 567 -> [1,2】 【57】
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                if (list.get(i) != list.get(i) - 1) {
                    end = i - 1;
                    int[] element = new int[2];
                    element[0] = start;
                    element[1] = end;
                    start = i;
                    res.add(element);
                }
            }

        }
        int[][]   arrRes =  new int[res.size()][2];
        for (int i = 0; i < arrRes.length; i++) {
            arrRes[i] = arrRes[i];
        }
        return arrRes ;
    }

    /**
     * @Description
     * @Date 2021/4/19 12:29
     **/
    @Test
    public void test493() {
        int[] a={1,3,2,3,1} ;

        int[] b=   {2,4,3,5,1};
        int[] c= {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
//        System.out.println(reversePairs(a));
//        System.out.println(reversePairs(b));
        System.out.println(reversePairs(c));
    }
    public int reversePairs(int[] nums) {
        if(nums.length< 2){
             return 0;
        }
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>2*nums[j]) {
                     count++;
                }
            }
        }
        return  count;
    }

}
