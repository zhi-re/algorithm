package org.maimai.hash;

import org.junit.Test;

import java.util.HashMap;

/**
 * BM51 数组中出现次数超过一半的数字
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *
 * @Date 2023/1/1 23:49
 * @Author chenqi
 */
public class MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = array.length / 2;
        System.out.println(length);
        int result = array[0];
        for (int i = 0; i < array.length; i++) {
            System.out.println(map);
            if (map.containsKey(array[i])) {
                if (map.get(array[i]) >= length) {
                    result = array[i];
                } else {
                    map.put(array[i], map.get(array[i]) + 1);
                }
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println(map);
        return result;
    }

    @Test
    public void t() {
        System.out.println((MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2})));
    }
}
