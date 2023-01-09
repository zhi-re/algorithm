package org.maimai.dtgh;

import org.junit.Test;

/**
 * BM66 最长公共子串
 * <p>
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 * 输入：
 * "1AB2345CD","12345EF"
 * 返回值：
 * "2345"
 *
 * @Date 2023/1/9 19:44
 * @Author chenqi
 */
public class LCS {
    /**
     * step 1：我们可以用dp[i][j]表示在str1中以第i个字符结尾在str2中以第j个字符结尾时的公共子串长度，
     * step 2：遍历两个字符串填充dp数组，转移方程为：如果遍历到的该位两个字符相等，则此时长度等于两个前一位长度+1，
     * dp[i][j]=dp[i−1][j−1]+1，如果遍历到该位时两个字符不相等，则置为0，因为这是子串，必须连续相等，断开要重新开始。
     * step 3：每次更新dp[i][j]后，我们维护最大值，并更新该子串结束位置。
     * step 4：最后根据最大值结束位置即可截取出子串。
     *
     * @param str1
     * @param str2
     * @return
     */
    public String LCS(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        int index = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                System.out.println(i);
                System.out.println(j);
                System.out.println();
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    index = i - 1;
                }
            }
        }
        return str1.substring(index - max + 1, index + 1);
    }

    public String LCS2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals(" ") || str2.equals(" ")) {
            return "-1";
        }
        // 动态规划  二维数组，斜下来就是最长字串
        int str1len = str1.length();
        int str2len = str2.length();
        int maxLen = 0;
        int index = 0;
        // 定义一个二维数组
        int[][] dp = new int[str1len][str2len];
        // 第一步：划分
        for (int i = 0; i < str1len; i++) {
            for (int j = 0; j < str2len; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (j == 0 && i == 0) {
                        dp[i][j] = 1;
                        maxLen = dp[i][j];
                        index = i;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if (maxLen <= dp[i][j]) {
                            maxLen = dp[i][j];
                            index = i;
                        }
                    }
                }
            }
        }
        if (maxLen == 0) {
            return "-1";
        }
        return str1.substring(index - maxLen + 1, index + 1);
    }


    @Test
    public void t() {
        System.out.println(LCS("1AB2345CD", "12345EF"));
        System.out.println(LCS2("1AB2345CD", "12345EF"));
        System.out.println("ABC".charAt(1));
    }


}
