package test;

import org.junit.Test;

/**
 * @Author: twc
 * @Date 2021/5/7 14:34
 **/
public class testStringBuilder {

    //测试删除 stringbuilder deleteCharAt(0)
    @Test
    public void testStringBuilderDeleteCharAt() {
        StringBuilder sb = new StringBuilder("D");
        StringBuilder stringBuilder = sb.deleteCharAt(0);
        System.out.println("输出结果：" +stringBuilder.toString());
    }

}
