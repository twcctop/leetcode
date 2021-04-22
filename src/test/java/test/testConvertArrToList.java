package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: twc
 * @Date 2021/4/10 23:29
 **/
public class testConvertArrToList {
    @Test
    public void testArrays(){
        int[] spam = new int[] { 1, 2, 3 };
        List<Integer> res = Arrays.stream(spam).boxed().collect(Collectors.toList());
        System.out.println(res);
    }


}
