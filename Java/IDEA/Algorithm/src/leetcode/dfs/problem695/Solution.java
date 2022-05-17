package leetcode.dfs.problem695;

public class Solution {

    int[][] grid;
    int m;
    int n;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        int maxArea = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }
        return maxArea;
    }

    int[] directions = {-1, 0, 1, 0, -1};

    public int dfs(int x, int y) {
        int area = 1;
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int r = x + directions[i];
            int c = y + directions[i + 1];
            if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                area += dfs(r, c);
            }
        }
        return area;
    }
}