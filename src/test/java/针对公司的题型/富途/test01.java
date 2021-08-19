package 针对公司的题型.富途;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: twc
 * @Date 2021/8/15 15:34
 **/
public class test01 {

    // 无序数组，找大于前面所有数字，小于后面所有数字的一个数

    /**
     * @Description
     * @Date 2021/8/15 15:35
     **/
    @Test
    public void test() {



    }
    public  int  getFirstNum(List<Integer> list){
        Map<Integer,Integer> revervsMap=new HashMap<>();
//        int min = ...
        for (int i = list.size()-1; i>0; i--) {

        }
        return  0;
    }

    //二叉树插入节点
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) {
             return  new TreeNode(val);
        }
        TreeNode pos=  root;
        while(pos!=null){
            if(val<root.val){
                if (pos.left==null) {
                    pos.left=new TreeNode(val);
                    break;
                }else {
                     pos=pos.left;
                }
            }else {
                if (pos.right==null) {
                    pos.right= new TreeNode(val);
                    break;
                }else {
                     pos= pos.right;
                }
            }
        }
        return   root;
    }
    //反转二叉树

    public TreeNode invertTree(TreeNode root) {
         TreeNode curNode = root;
         reverse(curNode);
         return  root;
    }

    private void reverse(TreeNode curNode) {
        if (curNode==null) {
             return;
        }
        TreeNode temp=curNode.left;
        curNode.left=curNode.right;
        curNode.right=temp;
        reverse(curNode.left);
        reverse(curNode.right);
    }

    // 对角线元素之和
    public int diagonalSum(int[][] mat) {
        if (mat.length==0) {
            return  0;
        }
        int res= 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i+j== mat.length-1 ||  i==j) {
                    res+=mat[i][j];
                }

            }
        }
//        if (mat.length%2==1 && mat.length>2) {
//            int middle =(mat.length-1)/2;
//             res= res-mat[middle][middle];
//        }
        return res;

    }

    //7,1,5,3,6,4
    //买股票的最佳时机
    public int maxProfit(int[] prices) {
        int minValue=prices[0];
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            minValue= Math.min(minValue,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-minValue);
        }
        return maxProfit;
    }

    //排序数组   冒泡排序  快速排序 堆排序
    //1 冒泡
    public int[] sortArrayBubbleSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]) {
                    //交换两个元素
                     int temp= nums[i];
                     nums[i]= nums[j];
                      nums[j]=temp;
                }

            }
        }
        return  nums;
    }

    // 快排
    //   https://leetcode-cn.com/problems/sort-an-array/
    public int[] sortArrayQuickSort(int[] nums) {
        return quickSort(nums,0,nums.length-1);

    }

    private int[] quickSort(int[] nums, int left, int right) {
          if(left< right){
                int partition = partionArea(nums,left,right);
                quickSort(nums, left, partition-1);
                quickSort(nums,partition+1,right);
          }
          return nums;
    }
    //todo  索引错误
    private int partionArea(int[] nums, int left, int right) {
        int index=left;
        for (int i = left+1; i <= right; i++) {
            if (nums[i]<nums[left]) {
                int temp =nums[i];
                 nums[i]= nums[left];
                  nums[left]= temp;
                  index++;
            }
        }
        return  index;
    }


}
