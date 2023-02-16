package com.fouze.dtgh;

/**
 * BM64 最小花费爬楼梯
 * 给定一个整数数组 cost   ，其中 cost[i]  是从楼梯第i个台阶向上爬需要支付的费用，下标从0开始。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * @Date 2023/1/9 19:26
 * @Author chenqi
 */
public class MinCostClimbingStairs {
    /**
     * step 1：可以用一个数组记录每次爬到第i阶楼梯的最小花费，然后每增加一级台阶就转移一次状态，最终得到结果。
     * step 2：（初始状态） 因为可以直接从第0级或是第1级台阶开始，因此这两级的花费都直接为0.
     * step 3：（状态转移） 每次到一个台阶，只有两种情况，要么是它前一级台阶向上一步，要么是它前两级的台阶向上两步，
     * <p>
     * 因为在前面的台阶花费我们都得到了，因此每次更新最小值即可，转移方程为：
     * dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])。
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            int min = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            dp[i] = min;
        }
        return dp[cost.length];
    }
}
