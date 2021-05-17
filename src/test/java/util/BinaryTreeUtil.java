package util;

import com.alibaba.fastjson.JSON;
import entity.TreeNode;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/5/17 12:02
 **/
public class BinaryTreeUtil {

    public static TreeNode str2tree(String str){
        int[]  ints = JSON.parseObject(str, int[].class);
        Queue<Integer>  list= new LinkedList<>();
        for (int anInt : ints) {
            list.offer(anInt);
        }
        TreeNode head = new TreeNode(list.poll());
        Map<Integer,List<TreeNode>> map =new HashMap<>();
        //第一层节点
        map.put(1,Arrays.asList(head));
        //第二层节点
        List<TreeNode> listNode2 =  new ArrayList<>();
        makeNode(list,head,listNode2);
        //第三层节点
        List<TreeNode> listNode3 =  new ArrayList<>();
        for (TreeNode treeNode : listNode2) {
            makeNode(list, treeNode, listNode3);
        }
        //第四层 。。。
        return head;
    }

    private static void makeNode(Queue<Integer> list, TreeNode head,List<TreeNode> nodeList) {
        if (list.isEmpty()) {
             return;
        }
        TreeNode left = new TreeNode(list.poll());
        head.left= left;
        nodeList.add(left);


        if (list.isEmpty()) {
             return;
        }
        TreeNode right=new TreeNode(list.poll());
        head.right =right;
        nodeList.add(right);
    }
}
