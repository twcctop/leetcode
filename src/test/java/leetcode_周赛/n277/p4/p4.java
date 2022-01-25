package leetcode_周赛.n277.p4;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class p4 {

  /**
   * @Description
   * @Date 2022/1/23 11:01
   **/
  @Test
  public void test() {
  }


  public int maximumGood(int[][] statements) {

    int count =0;
    for (int i = 0; i < statements.length; i++) {
      //第几个人将真话
      int  cur =1 ;
      int[] statement = statements[i];
      Set<Integer> incoreset=new HashSet<>();
      for (int j = 0; j < statement.length; j++) {

        if (statement[j]== 0) {
          //
          incoreset.add(j);
        }else if(statement[j] ==1){
            cur ++ ;
          //递归
          int i1 = statement[j];
          //放弃，没有思路

        }


      }

      count=Math.max(cur,count);

    }

    return  count;

  }





}
