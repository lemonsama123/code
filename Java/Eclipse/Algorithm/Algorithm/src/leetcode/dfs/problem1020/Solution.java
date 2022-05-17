package leetcode.dfs.problem1020;

public class Solution {

    int[] directions = {-1, 0, 1, 0, -1};
    int[][] grid;
    int m;
    int n;

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i);
            }
            if (grid[m - 1][i] == 1) {
                dfs(m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(i, n - 1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ++count;
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c) {
        grid[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int x = r + directions[i];
            int y = c + directions[i + 1];
            if (x >= 0 && y >=0 && x < m && y < n && grid[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}