package org.maimai.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.*;

/**
 * BM58 字符串的排列
 * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
 * <p>
 * step 1：先对字符串按照字典序排序，获取第一个排列情况。
 * step 2：准备一个空串暂存递归过程中组装的排列情况。使用额外的vis数组用于记录哪些位置的字符被加入了。
 * step 3：每次递归从头遍历字符串，获取字符加入：首先根据vis数组，已经加入的元素不能再次加入了；
 * 同时，如果当前的元素str[i]与同一层的前一个元素str[i-1]相同且str[i-1]已经用，也不需要将其纳入。
 * step 4：进入下一层递归前将vis数组当前位置标记为使用过。
 * step 5：回溯的时候需要修改vis数组当前位置标记，同时去掉刚刚加入字符串的元素，
 * step 6：临时字符串长度到达原串长度就是一种排列情况。
 *
 * @Date 2023/1/4 20:08
 * @Author chenqi
 */
public class Permutation {

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> res = new ArrayList<>();
        boolean[] vis = new boolean[str.length()];
        Arrays.fill(vis, false);
        StringBuilder temp = new StringBuilder();
        recursion(res, chars, temp, vis);
        return res;
    }


    private void recursion(ArrayList<String> res, char[] str, StringBuilder temp, boolean[] vis) {
        // 递归的结束条件，临时字符串的长度等于数组长度
        if (temp.length() == str.length) {
            // 把临时字符串加入结果集
            res.add(temp.toString());
            return;
        }
        // 遍历数组
        for (int i = 0; i < str.length; i++) {
            // 如果当前字符和当前字符前一个相等，或者当前字符前一个已经用过了
            if (i != 0 && str[i] == str[i - 1] && !vis[i - 1]) continue;
            // 当前字符前一个已经用过了
            if (vis[i]) continue;
            // 标记已经使用过
            vis[i] = true;
            // 加入临时字符串
            temp.append(str[i]);
            // 递归
            recursion(res, str, temp, vis);
            // 回溯
            vis[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }


    @Test
    public void t() {
        System.out.println(Permutation("123"));
    }
}
