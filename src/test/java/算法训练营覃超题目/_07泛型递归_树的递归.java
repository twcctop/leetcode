package 算法训练营覃超题目;

import entity.TreeNode;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/3/12 14:30
 **/
public class _07泛型递归_树的递归 {


    /**
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */

    //括号生成
    @Test
    public void test22(){

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backTrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    public void backTrack(List<String> ans,StringBuilder cur,int open,int close, int max){
          // n*2 为 括号最长长度
         if(cur.length()== max*2) {
              ans.add(cur.toString());
              return;
         }
          if(open<max){
              cur.append('(');
              backTrack(ans,cur,open+1, close,max);
              cur.deleteCharAt(cur.length() - 1);
          }
        if (close < open) {
            cur.append(')');
            backTrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    //
    //反转二叉树
    @Test
    public void test226(){

    }

    public TreeNode invertTree(TreeNode root) {
         invert(root);
         return root;
    }

    private void invert(TreeNode root) {
        if (root==null) {
             return;
        }
        TreeNode temp = root.left;
        root.left=root.right;
        root.right= temp;
        invert(root.right);
        invert(root.left);
    }

    @Test
    public void test98(){

         TreeNode  node1 = new TreeNode(1);
         TreeNode  node2 = new TreeNode(2);
         TreeNode  node3 = new TreeNode(3);
          node1.left=node2;
          node1.right=node3;

        System.out.println(isValidBST(node1));
    }

    public boolean isValidBST(TreeNode root) {
        ArrayList flagList  =new ArrayList<>();
        validBst(root,flagList);
        return   flagList.size()==0;
    }

    private void validBst(TreeNode root, List flag) {
        if (root==null ) {
            return;
        }


        if( root.left==null && root.right==null){
            return;
        }

        if(root.left!=null && root.right!=null  &&           root.left.val < root.val  && root.right.val > root.val){
               validBst(root.left,flag);
               validBst(root.right,flag);
        }else if(root.left!=null&&root.right==null &&    root.left.val < root.val){
            validBst(root.left,flag);
        }else if(root.left==null&&root.right!=null &&    root.right.val > root.val){
            validBst(root.right,flag);
        } else {
             flag.add("1");
             return;
        }
    }


    // 二叉树的最小深度
    @Test
    public void test111(){


    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
         Integer min= Integer.MAX_VALUE;
         int[]  a = new int[1];
          a[0]= Integer.MAX_VALUE;
         int res =0;
         getDepth(root,a[0],res);
         return  a[0];
    }

    private void getDepth(TreeNode root, Integer min, int res) {
        if (root==null) {
             return;
        }
        res++;
        if (root.left==null && root.right==null) {
              min= min<res?min:res;
              return;
        }
        getDepth(root.left,min,res);
        getDepth(root.right,min,res);
    }


    // 二叉树序列化
    @Test
    public void test297(){
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

         return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

}
