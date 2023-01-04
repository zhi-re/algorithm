package org.maimai.hash;

/**
 * BM57 岛屿数量
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 * 例如：
 * 输入
 * [
 * [1,1,0,0,0],
 * [0,1,0,1,1],
 * [0,0,0,1,1],
 * [0,0,0,0,0],
 * [0,0,1,1,1]
 * ]
 * 对应的输出为3
 *
 * @Date 2023/1/3 19:38
 * @Author chenqi
 */
public class DaoYuShuLiang {

    public int solve(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            //    char[] chars = grid[i];
            //    for (int j = 0; j < chars.length; j++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dpRowAndColumn(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }


    // 1 1   1  1 1 1
    // 1 1 (c,r) 1 1 1
    // 1 1   1  1 1 1
    private void dpRowAndColumn(char[][] grid, int c, int r) {
        // 判断坐标 (r, c) 是否在网格中
        if (c < 0 || c >= grid.length || r < 0 || r >= grid[0].length)
            return;

        // 如果这个格子不是岛屿，直接返回
        if (grid[c][r] != '1') return;

        // 将格子标记为「已遍历过」
        grid[c][r] = '2';

        //以grid[c][r]为中心 遍历上下左右相邻的格子
        dpRowAndColumn(grid, c - 1, r);
        dpRowAndColumn(grid, c + 1, r);
        dpRowAndColumn(grid, c, r - 1);
        dpRowAndColumn(grid, c, r + 1);

    }


}
