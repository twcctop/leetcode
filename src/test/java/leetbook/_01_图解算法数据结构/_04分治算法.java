package leetbook._01_图解算法数据结构;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: twc
 * @Date 2021/6/7 11:52
 **/
public class _04分治算法 {
    /**
     *@Description
     *@Date 2021/6/15 15:10
     **/
    class Solution07{
        //07 重建二叉树
         private Map<Integer,Integer> indexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n= preorder.length;
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                 indexMap.put(inorder[i],i);
            }
            TreeNode root =null ;
//            return myBuildTree(preorder,inorder,0,n-1,0,n-1);
            twcBuildTree(root,preorder,inorder);
            return root;
        }

        private void twcBuildTree(TreeNode root, int[] preorder, int[] inorder) {
            if (root==null) {

            }

        }

        private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                 return  null;
            }
            //前序遍历中第一个节点是根节点
            return null;
        }


    }

    class Solution16 {
        public double myPow(double x, int n) {
             double res=1;
             int count =0,leftCount=n%2;
             while(n%2!=0){
                  n=n/2;
                  count++;
             }
                return  0l;
        }
    }

    class Solution17 {
        public int[] printNumbers(int n) {
            double pow = Math.pow(10, n);
            int a= (int) pow;
            int[] res = new int[a-1];
            for (int i = 0; i < a; i++) {
                 res[i]= i+1;
            }
            return  res;
        }
    }
    //二叉树的后序搜索
    //todo  理解不了
    class Solution33 {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder,0, postorder.length-1);
        }

        private boolean recur(int[] postorder, int i, int j) {
            if (i>=j) {
                 return true;
            }
            int p=i;
            while (postorder[p]<postorder[j]){
                 p++;
            }

            int m=p;
            while(postorder[p]>postorder[j]){
                  p++;
            }
            return  p==j && recur(postorder,i,m-1) && recur(postorder,m,j-1);
        }

    }


    class Solution51 {
        public int reversePairs(int[] nums) {
            return  0;
        }
    }


}
