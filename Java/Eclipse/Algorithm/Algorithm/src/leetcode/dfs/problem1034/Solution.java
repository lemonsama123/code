package leetcode.dfs.problem1034;

public class Solution {

    int[] directions = {-1, 0, 1, 0, -1};
    int[][] grid;
    int m;
    int n;
    boolean[][] visited;
    int oldColor;
    int newColor;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        this.m = grid.length;
        this.n = grid[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return grid;
        }
        this.oldColor = grid[row][col];
        this.newColor = color;
        if (oldColor == newColor) {
            return grid;
        }
        this.grid = grid;
        visited = new boolean[m][n];
        dfs(row, col);
        return grid;
    }

    public void dfs(int r, int c) {
        visited[r][c] = true;
        if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
            grid[r][c] = newColor;

        }
        for (int i = 0; i < 4; i++) {
            int x = r + directions[i];
            int y = c + directions[i + 1];
            if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                if (grid[x][y] != oldColor) {
                    grid[r][c] = newColor;
                } else {
                    dfs(x, y);
                }
            }
        }
    }
}