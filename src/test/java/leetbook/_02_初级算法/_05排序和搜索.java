package leetbook._02_初级算法;

import org.junit.Test;

/**
 * @Author: twc
 * @Date 2021/6/21 15:36
 **/
public class _05排序和搜索 {


    /**
     * @Description
     * @Date 2021/6/21 15:56
     **/
    @Test
    public void test() {
        System.out.println(firstBadVersion(5));
    }
    public int firstBadVersion(int n) {
         int first=0,last=n;

        while(true){
            if (last-first<=1) {
                break;
            }

            //todo 真的很烦这种 避免边界的问题  int 想加越界
            int middle = first + (last - first) / 2;

            if (isBadVersion(middle)) {
                last=middle;
                continue;
            }else{
                first=middle;
                continue;
            }
        }
        return last;
    }

     public  Boolean isBadVersion(int version){
         if (version==1) {
              return false;
         }
         if (version==2) {
             return false;
         }
         if (version==3) {
             return false;
         }
//         if (version==4) {
//             return false;
//         }
//         if (version==3) {
//             return false;
//         }
//         if (version==3) {
//             return false;
//         }
             return  true;
     }

}
