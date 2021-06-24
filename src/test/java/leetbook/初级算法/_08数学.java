package leetbook.初级算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/6/22 16:02
 **/
public class _08数学 {

    /**
     * @Description
     * @Date 2021/6/22 16:08
     **/
    @Test
    public void test() {
        System.out.println(fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%3==0&&i%5==0&&i>=15) {
                res.add("FizzBuzz");
            }else if(i%3==0&& i>2 ){
                res.add("Fizz");
            }else if(i%5==0 && i>4){
                res.add("Buzz");
            }else {
                 res.add(String.valueOf(i));
            }
        }
        return  res;
    }



    //3的 幂
    public boolean isPowerOfThree(int n) {
         if(n<1){
             return  false;
         }
         while (n%3==0){
             n=n/3;
         }
         return n==1;
    }
}
