package leetcde_双周赛._n70;

import java.util.Arrays;
import org.junit.Test;
import util.ArrayUtil;

public class p1 {



  /**
   * @Description
   * @Date 2022/1/22 22:30
   **/
  @Test
  public void test() {
    int[] ints = ArrayUtil.convertStringIntToArray("[6,5,7,9,2,2]");
    System.out.println(minimumCost(ints));
  }


  @Test
  public void test2() {
    int[] ints = ArrayUtil.convertStringIntToArray("[3,3,3,1]");
    System.out.println(minimumCost(ints));
  }
  public int minimumCost(int[] cost) {
    if (cost.length==2) {
      return  cost[0]+cost[1];

    }
    if (cost.length==1) {
      return  cost[0];
    }

    int res= 0;
    Arrays.sort(cost);
    for (int i = cost.length-1; i >= 0; i--) {
       if( i==1){
         res+=cost[0];
         res+=cost[1];
         return  res;
       }
        if(i==0 ){
          res+=cost[0];
          return  res;

        }
       res += cost[i];
       res += cost[i-1];
       i-=2;
    }

    return  res;
  }
}
