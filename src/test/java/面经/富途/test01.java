package 面经.富途;

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

}
