package com.fouze.doublePointer;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;

/**
 * BM92 最长无重复子数组
 * 1 2 3 1 2 3
 *
 * @Date 2023-02-21 19:52
 * @Author chenqi
 */
public class ZuiChangWuChongFuZiShuZu {

    //  1 2 3 1 2 3
    public int maxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int start = 0, end = 0; end < arr.length; end++) {
            System.out.println("start:" + start);
            System.out.println("end:" + end);
            int arrEnd = arr[end];
            System.out.println("arrEnd:" + arrEnd);
            System.out.println("map:" + JSON.toJSONString(map));
            System.out.println("map.get(" + arrEnd + "):" + map.get(arrEnd));
            if (map.containsKey(arrEnd)) {
                //重复了
                // 1
                start = Math.max(start, map.get(arrEnd) + 1);
                System.out.println("start2:" + start);
                //注意：这里一定要取最大的start，不然就错误了
                //为什么？ 因为重复数字的索引很可能比start小
            }
            System.out.println();
            max = Math.max(max, end - start + 1);
            map.put(arrEnd, end);
        }
        System.out.println(JSON.toJSONString(map));
        return max;
    }

    @Test
    public void t() {
        System.out.println(maxLength(new int[]{1, 2, 3, 1, 2, 3}));
    }

}
