package 算法训练营覃超题目;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: twc
 * @Date 2021/3/15 11:31
 **/
public class _09深度优先_广度优先 {
    /**
     * @Description
     * @Date 2021/3/15 16:18
     **/
    @Test
    public void test102() {
        TreeNode node15= new TreeNode(15);
        TreeNode node7= new TreeNode(7);
        TreeNode node20= new TreeNode(20,node15,node7);
        TreeNode node9= new TreeNode(9);
        TreeNode node3= new TreeNode(3,node9,node20);
        System.out.println(levelOrder(node3));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Integer curLevel= 0;
        levelOrderRecuration(root, map,curLevel);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
             res.add(entry.getValue());
        }
        return res;
    }

    private void levelOrderRecuration(TreeNode root, Map<Integer, List<Integer>> map, int curLevel) {
        if (root==null) {
            return;
        }
        // 添加跟数值
        List<Integer> integerList = new ArrayList<>();
        if (map.containsKey(curLevel)) {
            integerList = map.get(curLevel);
        }


        integerList.add(root.val);
        map.put(curLevel, integerList);

        //左右
        if (root.left!=null) {
            levelOrderRecuration(root.left,map,curLevel+1);
        }
        if (root.right!=null) {
            levelOrderRecuration(root.right,map,curLevel+1);
        }
    }
}
