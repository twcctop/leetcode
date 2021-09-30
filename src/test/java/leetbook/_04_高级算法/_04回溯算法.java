package leetbook._04_高级算法;

import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;
import util.ArrayUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _04回溯算法 {

    //分割回文串
    public List<List<String>> partition(String s) {

        return null;
    }


    /**
     * @Description
     * @Date 2021/9/30 17:05
     **/
    @Test
    public void test() {
        char[][] chars = ArrayUtil.convertStringCharTwoDimensionArray("[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]]");
        String[] list= new String[4];
        list[0]="oath";
        list[1]="pea";
        list[2]="eat";
        list[3]="rain";
        System.out.println(findWords(chars, list));
    }

    /**
     * @Description
     * @Date 2021/9/30 17:18
     **/
    @Test
    public void test2() {
        char[][] chars = ArrayUtil.convertStringCharTwoDimensionArray("[[\"a\"]]");
        String[] list= new String[1];
        list[0]="a";
        System.out.println(findWords(chars, list));
    }

    //单词搜索
    //todo  无法避免   a a   _> work a ,a ,a 的情况
    public List<String> findWords(char[][] board, String[] words) {
        Map<Character,String> map =new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                     map.put(board[i][j], i+"-"+j);
            }
        }
        List<String> res= new ArrayList<>();
        for (String word : words) {
            char c = word.charAt(0);
            if (!map.containsKey(c)) {
                continue;
            }

            String s = map.get(c);
            String[] split = s.split("-");
            dfs(word,board,word,Integer.valueOf(split[0]),Integer.valueOf(split[1]),res);
        }
        res =res.stream().distinct().filter(s-> !s.equals("")).collect(Collectors.toList());
        return res;

    }

    private void dfs(String word, char[][] board, String current, Integer i, Integer j,List<String> res) {
        char[] chars = board[0];
        if (current.equals("")) {
            res.add(word);
            return;
        }
        if(i>=board.length || i<0 || j>=chars.length  || j<0){
            return;
        }

        String substring = current.substring(1);
        if (board[i][j]== current.charAt(0)) {
            dfs(word,board,substring,i+1,j,res);
            dfs(word,board,substring,i-1,j,res);
            dfs(word,board,substring,i,j+1,res);
            dfs(word,board,substring,i,j-1,res);
        }
    }

    //删除无效的括号
    public List<String> removeInvalidParentheses(String s) {
        return new ArrayList<>();
    }
}
