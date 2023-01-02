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

    /**
     * 具体做法：
     * <p>
     * step 1：排除边界特殊情况。
     * step 2：既然三元组内部要求非降序排列，那我们先得把这个无序的数组搞有序了，使用sort函数优先对其排序。
     * step 3：得到有序数组后，遍历该数组，对于每个遍历到的元素假设它是三元组中最小的一个，那么另外两个一定在后面。
     * step 4：需要三个数相加为0，则另外两个数相加应该为上述第一个数的相反数，我们可以利用双指针在剩余的子数组中找有没有这样的数对。双指针指向剩余子数组的首尾，如果二者相加为目标值，那么可以记录，而且二者中间的数字相加可能还会有。
     * step 5：如果二者相加大于目标值，说明右指针太大了，那就将其左移缩小，相反如果二者相加小于目标值，说明左指针太小了，将其右移扩大，直到两指针相遇，剩余子数组找完了。
     * 注：对于三个数字都要判断是否相邻有重复的情况，要去重。
     *
     * @param num
     * @return
     */
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
