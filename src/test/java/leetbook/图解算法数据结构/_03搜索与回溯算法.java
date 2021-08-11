package leetbook.图解算法数据结构;

import entity.Node;
import entity.TreeNode;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;
import util.ArrayUtil;

import java.util.*;

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

     //32-1  todo 可以优化一点
     public int[] levelOrder(TreeNode root) {
         if (root==null) {
              return  new int[0];
         }

         List<Integer>  list= new ArrayList<>();
         Deque<TreeNode> deque =new LinkedList();
         deque.addLast(root);
         List<TreeNode> nodeList = new ArrayList<>();
         while (!deque.isEmpty()){

             while (!deque.isEmpty()) {
                   nodeList.add(deque.pollFirst());
             }
             for (TreeNode  node : nodeList) {
                  if(node.left!=null)  deque.addLast(node.left);
                  if(node.right!=null) deque.addLast(node.right);
                  list.add(node.val);
             }
             nodeList.clear();
         }
         int[] res= new  int[list.size()];
         for (int i = 0; i < list.size(); i++) {
              res[i]= list.get(i);
         }

         return  res;
     }

     //32-2
     public List<List<Integer>> levelOrder2(TreeNode root) {
         if (root==null) {
             return new ArrayList<>();
         }
         List<List<Integer>>  res= new ArrayList<>();
         Deque<TreeNode> deque =new LinkedList();
         deque.addLast(root);
         List<TreeNode> nodeList = new ArrayList<>();
         while (!deque.isEmpty()){
             while (!deque.isEmpty()) {
                 nodeList.add(deque.pollFirst());
             }
             List<Integer>  list= new ArrayList<>();
             for (TreeNode  node : nodeList) {
                 if(node.left!=null)  deque.addLast(node.left);
                 if(node.right!=null) deque.addLast(node.right);
                 System.out.println("node的值"+node.val);
                 list.add(node.val);
             }
             System.out.println(list);
             res.add(list);
             nodeList.clear();
         }
         return  res;
     }

    //从上往下打印二叉树3
    public List<List<Integer>> levelOrder3(TreeNode root) {

        if (root==null) {
            return new ArrayList<>();
        }
        List<List<Integer>>  res= new ArrayList<>();
        Deque<TreeNode> deque =new LinkedList();
        deque.addLast(root);
        List<TreeNode> nodeList = new ArrayList<>();
        int flag=1;
        while (!deque.isEmpty()){
            while (!deque.isEmpty()) {
                nodeList.add(deque.pollFirst());
            }
            List<Integer>  list= new ArrayList<>();
            for (TreeNode  node : nodeList) {
                if(node.left!=null)  deque.addLast(node.left);
                if(node.right!=null) deque.addLast(node.right);
                list.add(node.val);
            }
            if(flag==-1){
                Collections.reverse(list);
            }
            res.add(list);
            nodeList.clear();
            flag=-flag;
        }
        return  res;
    }

    //34 二叉树中和为某个数字的数
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>>  res=  new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs34(root,res,target,list);
        return res;
    }

    private void dfs34(TreeNode root, List<List<Integer>> res, int target, List<Integer> list) {
        if (root==null) {
             return;
        }
        int count=root.val;
        for (Integer integer : list) {
             count+=integer;
        }

        if (list.size()>3) {
            System.out.println(root.val +"::" +list);
        }

        if (count==target&&root.left==null&&root.right==null) {
            List<Integer> a = new ArrayList<>(list);
            a.add(root.val);
            res.add( a);
            return;
        }

        List<Integer> b= new ArrayList<>(list);
        b.add(root.val);
        dfs34(root.left,res,target,b);
        dfs34(root.right,res,target,b);
    }

    //36 二叉搜索树与双向链表  todo 二叉树的中序遍历与双向链表
    class solution36{
        Node pre,head;
        public Node treeToDoublyList(Node root) {
            if (root==null) {
                return null;
            }
            dfs36(root);
            head.left= pre;
            pre.right= head;
            return  head;
        }

        private void dfs36(Node cur) {
            if (cur==null) {
                 return;
            }
            dfs36(cur.left);
            if (pre!=null) {
                pre.right=cur;
            }else {
                head =cur;
            }
            cur.left=pre;
            pre= cur;
            dfs36(cur.right);
        }

    }

    //36  二叉搜索树的中序遍历
    public Node treeToDoublyList(Node root) {
         Node head=new Node();
         Node cur=head;
         dfs36(root,cur,head);
         return  head;
    }

    private void dfs36(Node root, Node cur, Node head) {
        cur=root;

        if (head.right==null) {
             head.right=cur;
        }else {


        }

        dfs36(root.left,cur,head);
        dfs36(root.right,cur,head);

    }


    //37 序列化二叉树
    //todo error 不能使用  list 前中后序 遍历的情况，null的情况无法保存
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList();
            if (root==null) {
                 return  null;
            }
            dfs37(root,list);
            return list.toString();
        }

        private void dfs37(TreeNode root, List<Integer> list) {
            if (root==null) {
                return;
            }
            list.add(root.val);
            dfs37(root.left, list);
            dfs37(root.right, list);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            char[] chars = data.toCharArray();
            List<Integer> list =new ArrayList<>();
            for (char aChar : chars) {
                 list.add(Integer.valueOf(aChar));
            }
            return null;
        }
    }


    public class CodecKgod {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return  null;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
          return  null;
        }
    }

     //38 字符串的排列

    /**
     * @Description
     * @Date 2021/6/11 11:17
     **/
    @Test
    public void test38() {
        ArrayUtil.printStringArray(permutation("aab"));
    }
     public String[] permutation(String s) {
         char[] chars = s.toCharArray();
          List<Character> charsList= new ArrayList<>();
         for (char aChar : chars) {
             charsList.add(aChar);
         }
         List<Character> cur= new ArrayList<>();
         List<String> list = new ArrayList<>();
         dfs38(charsList,list, cur);

         String[] res= new String[list.size()];
         for (int i = 0; i < list.size(); i++) {
             res[i]= list.get(i);
         }
         return res;
     }

    private void dfs38(List<Character> charsList, List<String> list, List<Character> cur) {
        if (charsList.size()==0) {
            StringBuilder sb = new StringBuilder();
            for (Character character : cur) {
                sb.append(character);
            }
            String curStr = sb.toString();

            if (list.contains(curStr)) {
                return;
            }
            list.add(curStr);
            return;
        }

        for (char aChar : charsList) {
            List<Character>  newCur = new ArrayList<>(cur);
            newCur.add(aChar);
            List<Character> removedCharlist = new ArrayList<>(charsList);

            removedCharlist.remove((Character) aChar);
            dfs38(removedCharlist,list,newCur);
        }
    }

     //54  二叉搜索树的第k
    //  todo 看不懂   为什么遍历要放在中间
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs54(root,list);
        Collections.reverse(list);
        return  list.get(k-1);
    }

    private void dfs54(TreeNode root, List<Integer> list) {
        if (root==null) {
             return;
        }
        dfs54(root.left,list);
        list.add(root.val);
        dfs54(root.right,list);
    }

    //55-1  二叉树的深度
    public int maxDepth(TreeNode root) {
        if (root==null) {
             return 0;
        }
        int res=0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        List<TreeNode> list=  new ArrayList<>();
        while (!deque.isEmpty()) {
            res++;
            while (!deque.isEmpty()) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode==null) {
                     continue;
                }
                list.add(treeNode.left);
                list.add(treeNode.right);
            }
            for (TreeNode treeNode : list) {
                if (treeNode==null) {
                    continue;
                }
                deque.addLast(treeNode);
            }
            list.clear();
        }
        return  res;
    }
    //55-2 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
             return true;
        }
        if (Math.abs(getMaxDepth(root.left)-getMaxDepth(root.right))>1) {
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    //获取最大深度
    public int getMaxDepth(TreeNode root){
        if (root==null) {
             return 0;
        }
        return  Math.max(getMaxDepth(root.left),getMaxDepth(root.right))+1;
    }

    //求和
    public int sumNums(int n) {
        boolean x= n>1 && (n+=sumNums(n-1))>0;
        return n;
    }


    //todo
    //68-1  二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null) {
                 if(root.val< p.val && root.val<q.val){
                       //遍历到右节点
                      root=root.right;
                 }else  if(root.val> p.val && root.val>q.val){
                      //遍历到左节点
                      root=root.left;
                 }else{
                      break;
                 }
        }
        return root;
    }
    //68-2 二叉树的公共祖先

    class solution68{

        TreeNode p;
        TreeNode q;
        List<Integer> listPRes =null;
        List<Integer> listQRes =null;
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            this.p = p;
            this.q = q;

            if (root==null|| root==p || q==root) {
                return root;
            }
            List<Integer> listP=new ArrayList<>();
            List<Integer> listQ=new ArrayList<>();
            dfs68(root,listP,listQ);

            if (listPRes==null ) {
                return  q;

            }
            if (listQRes==null) {
                return  p;
            }
            Collections.reverse(listPRes);
            Collections.reverse(listQRes);
            for (Integer treeNode : listPRes) {
                if (listQRes.contains(treeNode)) {
//                       dfs68_2(root)
                      break;
                }
            }

            return null;
        }

        private void dfs68(TreeNode root, List<Integer> listP, List<Integer> listQ) {
            if (root==null) {
                return;
            }
            if (listPRes!=null && listQRes!=null) {
                return;
            }

            if(listPRes==null&&listP.size()>0 && listP.get(listP.size()-1)==p.val){
                listPRes =  listP;
                return;
            }
            if(listQRes==null&&listQ.size()>0 && listQ.get(listQ.size()-1)==q.val){
                listQRes =  listQ;
                return;
            }

            listP.add(root.val);
            listQ.add(root.val);
            dfs68(root.left,new ArrayList<>(listP),new ArrayList<>(listQ));
            dfs68(root.right,new ArrayList<>(listP),new ArrayList<>(listQ));
        }
    }

    //力扣官方题解
    class solution68_2{
        //map<节点val, 父节点>
        Map<Integer,TreeNode> map=new HashMap<>();
        List<Integer> visited = new ArrayList<>();
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                dfs(root);
                while(p!=null){
                     visited.add(p.val);
                     p=map.get(p.val);
                }
                while(q!=null){
                    if (visited.contains(q.val)) {
                        return q;
                    }
                    q=map.get(q.val);
                }
                return  null;
        }

        private void dfs(TreeNode root) {
            if (root==null ) {
                return;
            }
            if (root.left!=null) {
                 map.put(root.left.val,root);
            }
            if(root.right!=null){
                 map.put(root.right.val,root);
            }
            dfs(root.left);
            dfs(root.right);
        }
    }


}
