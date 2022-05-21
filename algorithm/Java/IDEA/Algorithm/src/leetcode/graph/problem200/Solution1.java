package leetcode.graph.problem200;

public class Solution1 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    int[] help = {-1, 0, 1, 0, -1};
    public void dfs(char[][] grid, int r, int c) {
        if (grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int i = 0; i < 4; i++) {
            int x = r + help[i];
            int y = c + help[i + 1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                dfs(grid, x, y);
            }
        }
    }
}