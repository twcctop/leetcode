package test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: twc
 * @Date 2021/3/24 15:06
 **/
public class testArrayCopy {
    /**
     * @Description
     * @Date 2021/3/24 15:06
     **/
    @Test
    public void test() {
        int[] source={3,2,1};
        int[] target=new int[source.length];
        System.arraycopy(source,0, target,0,source.length);
        Arrays.sort(source);
        System.out.println(Arrays.toString(source));
        System.out.println(Arrays.toString(target));
    }
}
