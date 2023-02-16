package com.fouze.stackAndqueueAndheap;

import org.junit.Test;

import java.util.*;

/**
 * BM46 最小的K个数
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4(任意顺序皆可)。
 * <p>
 * 知识点：优先队列
 * <p>
 * 优先队列即PriorityQueue，是一种内置的机遇堆排序的容器，分为大顶堆与小顶堆，大顶堆的堆顶为最大元素，其余更小的元素在堆下方，小顶堆与其刚好相反。
 * 且因为容器内部的次序基于堆排序，因此每次插入元素时间复杂度都是O(log2n))，而每次取出堆顶元素都是直接取出。
 * <p>
 * 思路：
 * <p>
 * 要找到最小的k个元素，只需要准备k个数字，之后每次遇到一个数字能够快速的与这k个数字中最大的值比较，每次将最大的值替换掉，
 * 那么最后剩余的就是k个最小的数字了。
 *
 * @Date 2022/12/30 16:29
 * @Author chenqi
 */
public class GetLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k == 0) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>((Comparator.reverseOrder()));
        for (int i = 0; i < input.length; i++) {
            if (queue.size() >= k) {
                if (queue.peek() > input[i]) {
                    queue.poll();
                    queue.offer(input[i]);
                }
            } else {
                queue.offer(input[i]);
            }
        }
        for (Integer integer : queue) {
            list.add(integer);
        }
        return list;
    }

    @Test
    public void t() {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(a, 4));
    }

    public static void main(String[] args) {
        // 优选队列 基于堆
        // 最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((Comparator.reverseOrder()));
        queue.offer(3);
        queue.offer(1);
        queue.offer(0);
        queue.offer(9);
        queue.offer(5);
        queue.offer(100);
        System.out.println(queue);
    }

}
