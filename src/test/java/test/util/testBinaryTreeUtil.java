package test.util;

import org.junit.Test;
import util.BinaryTreeUtil;

/**
 * @Author: twc
 * @Date 2021/5/17 14:57
 **/
public class testBinaryTreeUtil {
     @Test
     public void testStrToTree(){
         System.out.println(BinaryTreeUtil.str2tree("[1,2,3,4,5,6,7]").val);     //1
         System.out.println(BinaryTreeUtil.str2tree("[1,2,3,4,5,6,7]").left.val); //2
         System.out.println(BinaryTreeUtil.str2tree("[1,2,3,4,5,6,7]").left.left.val); //4
     }
}
