package _00_题型分类._04_双指针;

import org.junit.Test;

public class _11_盛水最多的容器 {

  //盛水最多的容器
  @Test
  public void test11(){

  }

  public int maxArea(int[] height) {
    int res=0;
    int right = height.length-1;
    int left =0;
    while(left<right){
      res=Math.max(res,(right-left)*Math.min(height[right],height[left]));
      if ( height[left]<height[right]){
        left++;
      }else {
        right--;
      }
    }

    return res;
  }
}
