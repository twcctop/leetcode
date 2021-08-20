package leetbook._03_中级算法;

import entity.Node;
import entity.TreeNode;
import org.junit.Test;
import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/6/26 20:03
 **/
public class _04树和图 {

    //二叉树的中序遍历
    /**
     *@Description
     *@Date 2021/6/26 20:08
    **/
    class Solution{
        List<Integer> list = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return list;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }

    //z型遍历二叉树
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
           return null;
    }


    /**
     * @Description
     * @Date 2021/6/26 20:41
     **/
    @Test
    public void test() {
        int[] s= ArrayUtil.convertStringIntToArray("[3,9,20,15,7]");
        int[] s2= ArrayUtil.convertStringIntToArray("[9,3,15,20,7]");
        buildTree(s,s2);
    }

    //前序和中序遍历构造出二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  myBuildTree(preorder,inorder,0,0);
    }

    //todo 不明白
    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preIndex, int inorderIndex) {
         if(preorder.length<= preIndex+1||inorder.length<=inorderIndex+1){
             return null;
         }
         TreeNode node= new TreeNode(preorder[preIndex]);
         TreeNode nodeLeft= new TreeNode(preorder[preIndex+1]);
         TreeNode right= myBuildTree(preorder,inorder,preIndex+2, inorderIndex+2);
          node.left=nodeLeft;
          node.right= right;
         return  node;

    }


    // 填充每个节点的下一个右侧节点指针
    public Node connect(Node root) {

         return  null;
    }


    //二叉搜索树中第k小的元素
    public int kthSmallest(TreeNode root, int k) {

        return  0;
    }


}
