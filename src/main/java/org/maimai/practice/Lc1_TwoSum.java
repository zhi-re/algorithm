package org.maimai.practice;

import org.junit.Test;

import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @Date 2022/10/9 16:49
 * @Author chenqi
 */
public class Lc1_TwoSum {















    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])) {
                Integer index = hashMap.get((target-nums[i]));
                result[0] = i;
                result[1] = index;
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }


    @Test
    public void t(){
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }








}
