package com.fouze.stackAndqueueAndheap;

import org.junit.Test;

import java.util.Stack;

/**
 * BM44 有效括号序列
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * @Date 2022/12/30 15:42
 * @Author chenqi
 */
public class ValidKuoHao {
    /**
     * 1：创建辅助栈，遍历字符串。
     * 2：每次遇到小括号的左括号、中括号的左括号、大括号的左括号，就将其对应的呦括号加入栈中，期待在后续遇到。
     * 3：如果没有遇到左括号但是栈为空，说明直接遇到了右括号，不合法。
     * 4：其他情况下，如果遇到右括号，刚好会与栈顶元素相同，弹出栈顶元素继续遍历。
     * 5：理论上，只要括号是匹配的，栈中元素最后是为空的，因此检查栈是否为空即可最后判断是否合法。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = {'(', ')', '{', '}', '[', ']'};
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == array[0]) {
                stack.push(array[1]);
            } else if (chars[i] == array[2]) {
                stack.push(array[3]);
            } else if (chars[i] == array[4]) {
                stack.push(array[5]);
            } else if (stack.isEmpty() || chars[i] != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void t() {
        System.out.println(isValid("(){}"));
        System.out.println(isValid("({})"));
    }
}
