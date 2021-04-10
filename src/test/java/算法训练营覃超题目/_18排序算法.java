package 算法训练营覃超题目;

import org.junit.Test;
import org.omg.CORBA.ARG_IN;

import java.awt.image.AreaAveragingScaleFilter;
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

        int[]  arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[]  arr2= {2,1,4,3,9,6};
        System.out.println(Arrays.stream(relativeSortArray(arr1, arr2)).boxed().collect(Collectors.toList()));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2)  {
         int[]  res  =  new int[arr1.length];
         List<Integer> arr2List = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        List<Integer> arr2ListNotRemove = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        List<Integer>  notCollect =  new ArrayList<>();
         int flag = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr2List.contains(arr1[i])) {
                //
                for (int j : arr1) {
                    if (j==arr1[i]) {
                        res[flag]= arr1[i];
                        flag++;
                    }
                }
                for (int k = 0; k < arr2List.size(); k++) {
                    if (arr2List.get(k)== arr1[i]) {
                         arr2List.remove(k);
                    }
                }
            }else{
                if (!arr2ListNotRemove.contains(arr1[i])) {
                notCollect.add(arr1[i]);
                }
            }
        }
        for (Integer integer : notCollect) {
              res[flag] = integer;
              flag++;
        }
        return  res;
    }
}
