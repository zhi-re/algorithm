package org.maimai.bsearch;

/**
 * BM18 二维数组中的查找
 *
 * @Date 2022/12/9 14:49
 * @Author chenqi
 */
public class Find {
    public boolean Find(int target, int[][] array) {
        for (int[] nums : array) {
            int start = 0;
            int last = nums.length - 1;
            while (start <= last) {
                int mid = (start + last) / 2;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] > target) {
                    last = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
