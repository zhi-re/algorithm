package org.maimai.stackAndqueueAndheap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Date 2022/12/30 17:34
 * @Author chenqi
 */
public class FindKth {

    public int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < a.length; i++) {
            queue.offer(a[i]);
        }

        return 0;
    }

}
