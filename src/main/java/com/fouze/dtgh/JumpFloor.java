package com.fouze.dtgh;

/**
 * BM63 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @Date 2023/1/9 19:21
 * @Author chenqi
 */
public class JumpFloor {
    public int jumpFloor(int target) {
        int a = 1;
        int b = 2;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int res = 0;
        for (int i = 3; i <= target; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
