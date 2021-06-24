package leetbook.初级算法;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/22 16:27
 **/
public class _09其他 {

    /**
     * @Description
     * @Date 2021/6/23 12:18
     **/
    @Test
    public void test() {
        System.out.println(hammingWeight(32));
    }

    //todo  位运算不明白
    public int hammingWeight(int n) {
        int res=0;
        for (int i = 0; i < 32; i++) {
//            if ((n& (1<<i)) ==1) {
            //todo  为什么  ==1不可以
            if ( (n& (1<<i)) ==1) {
                System.out.println(1<<i);
                res++;
            }
        }
        return  res;

    }

    //汉明distance  todo
    public int hammingDistance(int x, int y) {
       return  Integer.bitCount(x^y);
    }

    //颠倒二进制数  todo
    public int reverseBits(int n) {
        int rev=0;
        for (int i = 0; i < 32  && n!=0; i++) {
            rev |=(n&1) << (31-i);
            n>>>=1;
        }
        return  rev;
    }


    //杨辉三角 todo 想起来一个三角合并正方形的做法，太麻烦就不写了
    public List<List<Integer>> generate(int numRows) {

        return null;
    }


    /**
     * @Description
     * @Date 2021/6/23 14:41
     **/
    @Test
    public void testIs() {
        System.out.println(isValid("([)]"));
    }
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Deque<Character> deque1=new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                Character character = map.get(aChar);
                if (deque1.isEmpty()|| !deque1.getLast().equals(character)) {
                    return  false;
                }
                deque1.pollLast();
            }else{
                deque1.addLast(aChar);
            }
        }
        return deque1.isEmpty();
    }

    //todo 错了 , 需要用位运算
    public int missingNumber(int[] nums) {
        int left=0,right=nums.length;
        while(true){
        int middle= left/2 + right/2;
            if (middle==left||middle==right) {
                return  left+1;
            }
            if (nums[middle]==middle) {
                left=middle;
            }else {
                right=middle;
            }
        }
    }

    //todo 无聊题目 排序循环即可
    public int missingNumber2(int[] nums) {
         Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[0]+i) {
                 return  nums[0]+i;
            }
        }
        return  0;
    }
}
