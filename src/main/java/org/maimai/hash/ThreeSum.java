package org.maimai.hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * BM54 三数之和
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 *
 * @Date 2023/1/2 18:52
 * @Author chenqi
 */
public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = num.length;
        if (n < 3) return res;
        Arrays.sort(num);
        for (int i = 0; i < n - 2; i++) {
            // 解决数组都是0的情况
            if (i != 0 && num[i] == num[i - 1])
                continue;
            // 左指针
            int left = i + 1;
            // 右指针
            int right = n - 1;
            // 目标值
            int target = -num[i];
            // 循环条件
            while (left < right) {
                // 双指针指向的二值相加为目标，则可以与num[i]组成0
                if (num[left] + num[right] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    res.add(list);
                    while (left + 1 < right && num[left] == num[left + 1])
                        //去重
                        left++;
                    while (right - 1 > left && num[right] == num[right - 1])
                        //去重
                        right--;
                    //双指针向中间收缩
                    left++;
                    right--;
                    //双指针指向的二值相加大于目标，右指针向左
                } else if (num[left] + num[right] > target)
                    right--;
                    //双指针指向的二值相加小于目标，左指针向右
                else
                    left++;
            }
        }
        return res;
    }
}
