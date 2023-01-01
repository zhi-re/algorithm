package org.maimai.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * BM50 两数之和
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 *
 * @Date 2023/1/1 12:06
 * @Author chenqi
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int resultArr[] = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int result = target - numbers[i];
            if (map.containsKey(result)) {
                resultArr[0] = map.get(result) + 1;
                resultArr[1] = i + 1;
            } else {
                map.put(numbers[i], i);
            }
        }
        return resultArr;
    }

    @Test
    public void t() {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }
}
