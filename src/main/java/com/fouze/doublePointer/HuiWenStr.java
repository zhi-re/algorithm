package com.fouze.doublePointer;

import org.junit.Test;

/**
 * BM88 判断是否为回文字符串
 * 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
 *
 * @Date 2023-02-15 19:53
 * @Author chenqi
 */
public class HuiWenStr {

    // "absba"
    // true
    public boolean judge(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2 && j >= chars.length / 2; i++, j--) {
            if (chars[i] == chars[j]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void t() {
        System.out.println(judge("aaaaab"));
    }

}
