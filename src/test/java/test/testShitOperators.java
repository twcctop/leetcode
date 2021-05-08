package test;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @Author: twc
 * @Date 2021/3/15 14:17
 **/
public class testShitOperators {

    //测试位运算符
    @Test
    public void testShiftOperators(){
        int a = 8;
        System.out.println(a >> 1);
        System.out.println(a);
        System.out.println(a >> 2);
    }

    //测试 & 运算符
    @Test
    public  void testBit(){
        int  a= 8;    // 1000
        assertThat(a&1,is(0));

        int  b= 9;   // 1001
        assertThat(b&1,is(1));
    }

}
