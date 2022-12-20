package org.maimai.bsearch;

import org.junit.Test;

/**
 * BM21 旋转数组的最小数字
 * [3,4,5,1,2]
 *
 * @Date 2022/12/19 20:37
 * @Author chenqi
 */
public class MinNumberInRotateArray {


    /**
     * 时间复杂度O(logN)，二分
     * step 1：双指针指向旋转后数组的首尾，作为区间端点。
     * step 2：若是区间中点值大于区间右界值，则最小的数字一定在中点右边。
     * step 3：若是区间中点值等于区间右界值，则是不容易分辨最小数字在哪半个区间，比如[1,1,1,0,1]，应该逐个缩减右界。
     * step 4：若是区间中点值小于区间右界值，则最小的数字一定在中点左边。
     * step 5：通过调整区间最后即可锁定最小值所在
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;//取中间值
            if (array[mid] > array[right]) left = mid + 1;//搜索右边
            else if (array[mid] < array[right]) right = mid;//搜索左边
            else right -= 1;
        }
        return array[left];
    }

    @Test
    public void t() {
        int[] a = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(a));
    }
}
