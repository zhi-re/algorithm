package com.fouze.hash;

import org.junit.Test;

import java.util.*;

/**
 * BM52 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @Date 2023/1/2 18:02
 * @Author chenqi
 */
public class FindNumsAppearOnce {

    public int[] FindNumsAppearOnce(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
                if (map.get(array[i]) >= 2) {
                    list.add(array[i]);
                }
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println(list);
        for (Integer integer : list) {
            map.remove(integer);
        }
        System.out.println(map);
        Set<Integer> integers = map.keySet();
        int[] ints = integers.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }

    @Test
    public void t() {
        System.out.println((Arrays.toString(FindNumsAppearOnce(new int[]{1, 4, 1, 6}))));
    }
}
