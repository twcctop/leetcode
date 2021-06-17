package leetbook.图解算法数据结构;

import org.junit.Test;
import util.ArrayUtil;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/16 16:54
 **/
public class _10模拟 {

    //顺时针打印矩阵
        /**
         * @Description
         * @Date 2021/6/17 15:48
         **/
        @Test
        public void test29() {
            int[][] ints = ArrayUtil.convertStringTwoDimensionIntArray("[[1,2,3],[4,5,6],[7,8,9]]");
            ArrayUtil.printIntArray(spiralOrder(ints));
        }

        public int[] spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int i = 0, j = 0, direct = 0;
            int row= matrix.length;
            int column=matrix[0].length;
            if (row==0||column==0) {
                 return  new int[0];
            }
            int total= row*column;
            Set<String> footage = new HashSet<>();
            while (true) {
                list.add(matrix[i][j]);
                if (list.size() == total) {
                    break;
                }
                footage.add(i + "-" + j);
                //右
                if (direct == 0) {
                    if (footage.contains(i + "-" + (j + 1)) || j+1>= column) {
                        i++;
                        direct = 1;
                    } else {
                        j++;
                    }
                    // 下
                } else if (direct == 1) {
                    if (footage.contains((i + 1) + "-" + j) ||i+1>= row) {
                        j--;
                        direct = 2;
                    } else {
                        i++;
                    }

                    //左
                } else if (direct == 2) {
                    if (footage.contains(i + "-" + (j - 1)) || j-1<0) {
                        i--;
                        direct = 3;
                    } else {
                        j--;
                    }

                    //上
                } else if (direct == 3) {
                    if (footage.contains((i - 1) + "-" + j) ||i-1<0) {
                        j++;
                        direct = 0;
                    } else {
                        i--;
                    }
                }
            }

            int[] res = new int[list.size()];
            for (int i1 = 0; i1 < res.length; i1++) {
                res[i1] = list.get(i1);
            }
            return res;

        }

    /**
     * @Description
     * @Date 2021/6/17 14:52
     **/
    @Test
    public void test31() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
//         int[] poped={4,3,5,1,2};
        System.out.println(validateStackSequences(pushed, poped));
    }

    //栈的压入 弹出
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();

        for (int i = 0; i < pushed.length; i++) {
            deque1.addLast(pushed[i]);
        }
        boolean flag = false;
        for (int i = 0; i < popped.length; i++) {
            if (!deque1.isEmpty() && deque1.getLast().equals(popped[i])) {
                flag = true;
                deque1.pollLast();
            } else if (!deque2.isEmpty() && null != deque2.getLast() && deque2.getLast().equals(popped[i])) {
                flag = true;
                deque2.pollLast();
            } else {
                if (deque1.isEmpty()) {
                    break;
                }
                if (flag) {
                    continue;
                }
                deque2.addLast(deque1.pollLast());
                i--;
            }
        }
        return deque1.isEmpty() && deque2.isEmpty();
    }

    //弹出栈
    public boolean validateStackSequencesKGod(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            stack.addLast(num);
            while (!stack.isEmpty() && stack.getLast() == popped[i]) {
                stack.pollLast();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
