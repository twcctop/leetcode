package 手撕;

import org.junit.Test;
import util.ArrayUtil;

/**
 * @Author: twc
 * @Date 2021/7/14 17:34
 **/
public class 二分 {

    /**
     * @Description
     * @Date 2021/7/14 17:34
     **/

    /**
     * 采用二分法实现：在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * 示例：
     * 输入: [0,1,2,4,5,6,7,8,9,10,11,12,13]
     * 输出: 3￼
     */
    public int getMiddle(int[]  s) {
            int left=0,right=s.length-1,res=(left+right)/2;
            while(s[left]!=res){
                if (s[res]==res) {
                    left=res;

                } else{
                     right=res;
                }
                res=(left+right)/2;
            }
            return res+1;
    }

    /**
     * @Description
     * @Date 2021/7/14 17:41
     **/
    @Test
    public void test() {
        System.out.println(getMiddle(ArrayUtil.convertStringIntToArray("[0,1,2,3,5,6,7,8,9,10,11,12,13]")));
    }

}
