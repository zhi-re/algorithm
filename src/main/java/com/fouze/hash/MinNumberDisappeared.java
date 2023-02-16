package com.fouze.hash;

import org.junit.Test;

import java.util.*;


/**
 * BM53 缺失的第一个正整数
 * 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
 *
 * @Date 2023/1/2 18:24
 * @Author chenqi
 */
public class MinNumberDisappeared {

    public int minNumberDisappeared(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        int res = 1;
        while (map.containsKey(res))
            res++;
        return res;
    }

    @Test
    public void t() {
        System.out.println(((minNumberDisappeared(new int[]{1, 0, 2}))));
    }

}
