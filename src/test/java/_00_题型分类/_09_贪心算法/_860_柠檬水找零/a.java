package _00_题型分类._09_贪心算法._860_柠檬水找零;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class a {
  /**
   * @Description
   * @Date 2021/3/22 19:00
   **/
  @Test
  public void test860() {
//        int[] a={5,5,5,10,20} ;
//        int[] a={5,5,10,10,20} ;
    int[] a={5,5,5,5,10,5,10,10,10,20} ;

//        int[] a={10,10} ;
    System.out.println(lemonadeChange(a));
  }

  public boolean lemonadeChange(int[] bills) {
    Map<Integer, Integer> cash = new HashMap<>();
    for (int i = 0; i < bills.length; i++){
      if (bills[i]==5) {
        putMap(cash,5);
      }
      if (bills[i]==10) {
        if (cash.containsKey(5)) {
          putMap(cash,10);
          boolean b = removeMapOne(cash, 5);
          if (!b){
            return false;
          }
        }else {
          return  false;
        }

      }
      if (bills[i]==20) {
        if (cash.containsKey(10)&&cash.get(10)>0) {
          removeMapOne(cash,10);
          if (cash.containsKey(5)&&cash.get(5)> 0){
            removeMapOne(cash,5);
          }else {
            return false;
          }
        }else{
          if (cash.containsKey(5)&&cash.get(5)>2){
            removeMapOne(cash,5);
            removeMapOne(cash,5);
            removeMapOne(cash,5);
          }else {
            return  false;
          }
        }
      }
    }
    return true;
  }
  private boolean removeMapOne(Map<Integer, Integer> cash, int i) {
    if (cash.containsKey(i)) {
      Integer count = cash.get(i);
      if (count==1) {
        cash.remove(i);
      }else {
        cash.put(i,count-1);
      }
      return true;
    }else {
      return  false;
    }
  }

  private void putMap(Map<Integer, Integer> cash, int i) {
    if (cash.containsKey(i)) {
      cash.put(i,cash.get(i)+1);
    }else {
      cash.put(i,1);
    }
  }


  //test commit
}
