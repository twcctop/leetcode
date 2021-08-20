package leetbook._02_初级算法;

import entity.TreeNode;

/**
 * @Author: twc
 * @Date 2021/6/21 14:40
 **/
public class _04树 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.right,Integer.MIN_VALUE,Integer.MAX_VALUE)&&isValidBST(root.left,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int min, int max) {
        if (null==root) {
            return true;
        }
        if (null != root.left) {
            if (root.left.val >= root.val) {
                return  false;
            }
        }
        if(null!= root.right){
            if (root.right.val <= root.val) {
                return  false;
            }
        }

        if (root.val>=max || root.val<min) {
             return  false;
        }
        //todo 不太能理解
        return false;
    }

    //有序数组转换为二叉搜索树
    //todo 不明白
    public TreeNode sortedArrayToBST(int[] nums) {

        return  null;

    }


}
