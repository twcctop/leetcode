package 力扣剑指offer;

import entity.ListNode;

/**
 * @Author: twc
 * @Date 2021/5/27 14:43
 **/
public class offer_03_fjye {

    //51  todo 暴力超时
    public int reversePairs(int[] nums) {
        if (nums.length ==0 || nums.length==1) {
             return  0;
        }
        int[] curSum= new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
             int count=0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] >nums[j]) {
                     count++;
                }
            }
            curSum[i]=count;
        }
        int[] dp= new int[nums.length];
        dp[nums.length-1] = curSum[nums.length-1];
        for (int i = nums.length-2; i >=0; i--) {
              dp[i]=dp[i+1]+curSum[i];
        }
        return dp[0];
    }


    //52 两个链表公共节点
    //todo 不够优雅
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA!=null){
              ListNode curB = headB;
              while (curB!=null){
                  if (headA==curB) {
                      return  headA;
                  }
                  curB=curB.next;
              }
              headA=headA.next;
        }
        return   null;
    }

}
