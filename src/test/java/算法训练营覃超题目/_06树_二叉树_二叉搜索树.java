package 算法训练营覃超题目;

import entity.Node;
import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/3/10 17:16
 **/
public class _06树_二叉树_二叉搜索树 {

    @Test
    public void test94() {


    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        inorder2(root,res);
        return res;
    }

    private void inorder2(TreeNode root, List<Integer> res) {
        if (root==null) {
            return ;
        }

        inorder2(root.left,res);
        res.add(root.val);
        inorder2(root.right,res);
    }





    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    @Test
    public void test144(){

    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root==null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);


    }

    //n叉树的后序遍历
    @Test
    public void test590() {


    }
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        post(root,res);
        return res;
    }

    private void post(Node root, List<Integer> res) {
        if (root==null) {
            return;
        }
        for (Node child : root.children) {
            post(child,res);
        }
        //后序遍历
        res.add(root.val);
    }

    // n叉树层序遍历
    @Test
    public void test429() {


    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>  res = new ArrayList<>();
        level(root,res);
        return res;
    }

    private void level(Node root, List<List<Integer>> res) {
        if (root==null) {
             return;
        }

        List<Integer> list= new ArrayList<>();

        for (Node child : root.children) {
            list.add(child.val);
        }
        res.add(list);

    }


}
