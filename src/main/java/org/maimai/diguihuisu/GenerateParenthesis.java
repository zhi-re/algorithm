package org.maimai.diguihuisu;

import java.util.ArrayList;

/**
 * BM60 括号生成
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())"
 *
 * @Date 2023/1/7 21:16
 * @Author chenqi
 */
public class GenerateParenthesis {


    /**
     * step 1：将空串与左右括号各自使用了0个送入递归。
     * step 2：若是左右括号都使用了n个，此时就是一种结果。
     * step 3：若是左括号数没有到达n个，可以考虑增加左括号，
     * 或者右括号数没有到达n个且左括号的使用次数多于右括号就可以增加右括号。
     *
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesis(int n) {
        // 记录结果
        ArrayList<String> res = new ArrayList<>();
        recursion(0, 0, "", res, n);
        return res;
    }

    private void recursion(int left, int right, String temp, ArrayList<String> res, int n) {
        // 左右括号用完了，加入结果
        if (left == n && right == n) {
            res.add(temp);
            return;
        }
        // 使用一次左括号
        if (left < n) {
            recursion(left + 1, right, temp + "(", res, n);
        }
        // 使用右括号的次数必须小于左括号
        if (right < n && left > right) {
            recursion(left, right + 1, temp + ")", res, n);
        }
    }

}
