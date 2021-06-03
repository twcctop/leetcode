package leetbook_图解算法数据结构;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: twc
 * @Date 2021/6/2 16:29
 **/
public class _01_数据结构 {

    //09 两个栈实现队列  todo
    class CQueue {
        LinkedList<Integer> A;
        LinkedList<Integer> B;

        public CQueue() {
            A= new LinkedList<Integer>();
            B= new LinkedList<>();
        }

        public void appendTail(int value) {
             A.add(value);
        }

        public int deleteHead() {
            if(!B.isEmpty()){
             return   B.remove();
            }
            if (A.isEmpty()) {
                 return  -1;
            }
            while (!A.isEmpty()){
                  B.add(A.remove());
            }
            return  B.remove();

        }
    }

    //20  状态机
    public boolean isNumber(String s) {
        return false;
    }
}
