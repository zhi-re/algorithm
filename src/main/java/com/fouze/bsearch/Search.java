package com.fouze.bsearch;

/**
 * BM17 二分查找-I
 *
 * @Date 2022/12/8 19:57
 * @Author chenqi
 */
public class Search {

    // 1 2 3 4 5 / 5
    public int search(int[] nums, int target) {
        int start = 0;
        int last = nums.length - 1;
        while (start <= last) {
            int mid = (start + last) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


}
