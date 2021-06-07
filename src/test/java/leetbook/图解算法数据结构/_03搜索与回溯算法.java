package leetbook.图解算法数据结构;

import org.junit.Test;
import util.ArrayUtil;

import java.util.ArrayList;
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
}
