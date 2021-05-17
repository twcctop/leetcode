package test.queneOrStack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: twc
 * @Date 2021/3/15 14:17
 **/
public class testQuene {

    // 测试栈 quene
    @Test
    public void testQuene() {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        System.out.println(queue);

        /**
         * one
         * [two, three]
         */
        String polledElement = queue.poll();
        System.out.println(polledElement);
        System.out.println(queue);

        System.out.println("############");

        String peekedElement = queue.peek();
        /**
         * two
         * [two, three]
         */
        System.out.println(peekedElement);
        System.out.println(queue);
        System.out.println("############");

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
        System.out.println("############");
    }

    @Test
    public void testDeque() {
        Deque<String> deque = new LinkedList<String>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    @Test
    public void testStack(){
        Stack<Integer>  stack = new Stack<>();
         stack.add(1);
         stack.add(2);
         stack.add(3);
       while(!stack.empty()){
           System.out.println(stack.pop());
       }
    }

}
