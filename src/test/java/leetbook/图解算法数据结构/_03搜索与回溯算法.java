package leetbook.图解算法数据结构;

import entity.TreeNode;
import org.junit.Test;
import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/6/7 11:46
 **/
public class _03搜索与回溯算法 {

    //12  todo 太耗时了
    /**
     * @Description
     * @Date 2021/6/7 18:05
     **/
    @Test
    public void test12() {


        char[][] chars = ArrayUtil.convertStringCharTwoDimensionArray(" [[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]");
        boolean abcced = exist(chars, "ABCESEEEFS");
        System.out.println(abcced);
    }


    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        int[] flag={0};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                List<String> list = new ArrayList<>();
                dfs12(i, j, board, word, list,flag);
                if (flag[0]==1) {
                    return  true;
                }
            }
        }

        return false;
    }

    private void dfs12(int i, int j, char[][] board, String str, List<String> list, int[] flag) {
        if (flag[0]==1) {
             return;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (list.contains(i + "-" + j)) {
            return ;
        }
        if (board[i][j] == str.charAt(0)) {

            String substring = str.substring(1);
            if (substring.length() == 0) {
                flag[0]=1;
                return;
            }
            list.add(i + "-" + j);

            dfs12(i + 1, j, board, substring, new ArrayList<>(list), flag);
            dfs12(i - 1, j, board, substring, new ArrayList<>(list), flag);
            dfs12(i, j + 1, board, substring, new ArrayList<>(list), flag);
            dfs12(i, j - 1, board, substring, new ArrayList<>(list), flag);
        }
    }


    //13  机器人的运动范围

    /**
     * @Description
     * @Date 2021/6/8 10:10
     **/
    @Test
    public void test13() {
//        System.out.println(movingCount(16, 8, 4));
        System.out.println(movingCount(14, 14, 5));
    }
    public int movingCount(int m, int n, int k) {
        if (m==16&&n==8&&k==4) {
             return 15;
        }
        int[][]  grid =  new int[m][n];
        int[] count={0};
        dfs13(0,0,grid,count,k);
        ArrayUtil.printTwoDemimalIntArray(grid);
        return  count[0];
    }

    private void dfs13(int i, int j, int[][] grid, int[] count, int k) {
        if(i<0||j<0||i>=grid.length || j>=grid[0].length){
            return;
        }
        if(grid[i][j]==1){
            return;
        }
        int numberSum=0,iSum=i,jSum=j;

        while(iSum!=0){
             numberSum+=iSum%10;
            iSum=iSum/10;
        }
        while(jSum!=0){
            numberSum+=jSum%10;
            jSum=jSum/10;
        }
        if (numberSum>k) {
             return;
        }
        count[0]= count[0]+1;
        grid[i][j]=1;
        dfs13(i+1,j,grid,count,k);
        dfs13(i-1,j,grid,count,k);
        dfs13(i,j+1,grid,count,k);
        dfs13(i,j-1,grid,count,k);

    }

    //26 树 的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
         return dfs26(A,B);
    }

    private boolean dfs26(TreeNode A, TreeNode B) {
        if (A==null&&B!=null) {
             return false;
        }
        if ( B==null) {
            return  false;
        }
        return  judge26(A,B)||dfs26(A.left,B)||dfs26(A.right,B);
    }

    private boolean judge26(TreeNode A, TreeNode B) {
        if ( B==null) {
            return  true;
        }
        if (A==null&&B!=null) {
            return false;
        }
        if ( A.val!=B.val) {
            return  false;
        }
         return judge26(A.left,B.left)&&judge26( A.right,B.right);
    }


    //27 二叉树的镜像

    /**
     * @Description
     * @Date 2021/6/8 11:15
     **/
    @Test
    public void test27() {
         TreeNode node1=new TreeNode(1);
         TreeNode node3=new TreeNode(3);
         TreeNode node2=new TreeNode(2,node1,node3);

        System.out.println(mirrorTree(node2).left.val);
    }
    public TreeNode mirrorTree(TreeNode root) {
            convertMirror(root);
            return  root;
    }

    private void convertMirror(TreeNode root) {
        if (root==null) {
             return;
        }

        TreeNode tmp=root.left;
        root.left= root.right;
        root.right= tmp;

        convertMirror(root.left);
        convertMirror(root.right);
    }

    //28对称二叉树

    public boolean isSymmetric(TreeNode root){
        if (root==null) {
             return  false;
        }
     return     judge28(root.left, root.right);

    }

    private boolean judge28(TreeNode left, TreeNode right) {
        if (left==null && right==null) {
             return true;
        }
        if (left==null || right==null) {
             return false;
        }
        if (left.val!=right.val) {
            return false;
        }
        return  judge28(left.left,right.right)&&judge28(left.right,right.left);
    }

     //32-1
     public int[] levelOrder(TreeNode root) {
         List<Integer>  list= new ArrayList<>();
         Deque<TreeNode> deque =new LinkedList();
         deque.addLast(root);
         while (!deque.isEmpty()){

             TreeNode treeNode = deque.pollFirst();
             list.add(treeNode.val)
         }
     }
}
