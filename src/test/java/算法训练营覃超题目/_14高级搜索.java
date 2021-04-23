package 算法训练营覃超题目;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: twc
 * @Date 2021/4/23 15:41
 **/
public class _14高级搜索 {

    /**
     * @Description爬楼梯
     * @Date 2021/4/23 15:42
     **/
    @Test
    public void test70() {
    }


    /**
     * @Description 括号生成
     * @Date 2021/4/23 15:49
     **/
    @Test
    public void test22() {
        System.out.println(generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans,new StringBuilder(),n,0,0);
        return  ans;
    }

    private void backTrack(List<String> ans, StringBuilder stb, int n, int open, int close) {
        if (open+close == n * 2 && open==n && close==n) {
            ans.add(stb.toString());
            return;
        }
        if (open+close>=2*n) {
            return;
        }
        // 去枝
        if(open < close || open >n || close>n ){
             return;
        }
        if (open==close) {
            stb.append('(');
            backTrack(ans, stb, n, open + 1, close);
            return;
        }

        stb.append('(');
        backTrack(ans, stb, n, open + 1, close);

        stb.deleteCharAt(stb.length()-1);
        stb.append(')');
        backTrack(ans,stb,n,open,close+1);

    }


    /**
     * @Description
     * @Date 2021/4/23 16:43
     *
     **/
    @Test
    public void test36() {


    }


    public boolean isValidSudoku(char[][] board) {


        // 校验行
        for (int i = 0; i < board.length; i++) {
            List<Character> list= new ArrayList<>();
            for (int j = 0; j < board[0].length; j++) {
                if (list.contains(board[i][j])) {
                    return  false;
                }
                if(0< (int) board[i][j] && (int) board[i][j] <10){
                    list.add(board[i][j]);
                }
            }
        }

        //校验列
        for (int j = 0; j < board[0].length; j++) {
            List<Character> list= new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                if (list.contains(board[i][j])) {
                    return  false;
                }
                if(0< (int) board[i][j] && (int) board[i][j] <10){

                list.add(board[i][j]);
                }
            }
        }
        // 校验三格
        List<Character> list = new ArrayList<>();


         return true;
    }
}
