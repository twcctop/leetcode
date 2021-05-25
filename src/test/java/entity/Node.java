package entity;

import java.util.List;

/**
 * @apiNote   树中的节点
 * @Author: twc
 * @Date 2021/3/12 12:12
 **/
public class Node {

    public int val;
    public Node left;
    public Node right;

    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
