package org.maimai.dtgh;

/**
 * BM62 斐波那契数列
 * 斐波那契数列公式为:F(n)=F(n−1)+F(n−2)
 * 初始化第1项和第2项为1
 * 求该数列第n项
 * <p>
 * step 1：低于2项的数列，直接返回n。
 * step 2：初始化第0项，与第1项分别为0，1.
 * step 3：从第2项开始，逐渐按照公式累加，并更新相加数始终为下一项的前两项。
 *
 * @Date 2023/1/8 20:50
 * @Author chenqi
 */
public class Fibonacci {

    public int fibonacci(int n) {
        // 从0开始，第0项是0，第一项是1
        if (n < 2) return n;
        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            // 第三项开始是前两项的和，然后保留最新的两项，更新数据相加
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

}
