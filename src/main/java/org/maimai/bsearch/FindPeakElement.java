package org.maimai.bsearch;

/**
 * BM19 寻找峰值
 * [2,4,1,2,7,8,4]
 * 1/5
 *
 * @Date 2022/12/9 14:59
 * @Author chenqi
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums == null) return -1;
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findPeakElement(a));
    }
}
