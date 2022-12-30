package org.maimai.stackAndqueueAndheap;

import java.util.Stack;

/**
 * BM42 用两个栈实现队列
 * 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 *
 * @Date 2022/12/29 22:31
 * @Author chenqi
 */
public class TwoStackToQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 1：push操作就正常push到第一个栈末尾。
     * 2：pop操作时，优先将第一个栈的元素弹出，并依次进入第二个栈中。
     * 3：第一个栈中最后取出的元素也就是最后进入第二个栈的元素就是队列首部元素，要弹出，此时在第二个栈中可以直接弹出。
     * 4：再将第二个中保存的内容，依次弹出，依次进入第一个栈中，这样第一个栈中虽然取出了最里面的元素，但是顺序并没有变。
     *
     * @return
     */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        Integer pop = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return pop;
    }
}
