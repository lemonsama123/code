package leetcode.dfs.problem200;

public class Solution {

    char[][] grid;
    int m;
    int n;
    int[] directions = {-1, 0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c) {
        grid[r][c] = '0';
        for (int i = 0; i < 4; i++) {
            int x = r + directions[i];
            int y = c + directions[i + 1];
            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') {
                dfs(x, y);
            }
        }
    }
}