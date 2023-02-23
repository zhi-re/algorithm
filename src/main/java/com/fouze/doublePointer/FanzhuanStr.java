package com.fouze.doublePointer;

/**
 * BM91 反转字符串
 * "abcd"
 *
 * "dcba"
 *
 * @Date 2023-02-21 19:43
 * @Author chenqi
 */
public class FanzhuanStr {

    public String solve(String str) {
        char[] chars = str.toCharArray();
        StringBuilder s = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            s.append(chars[i]);
        }
        return s.toString();
    }

}
