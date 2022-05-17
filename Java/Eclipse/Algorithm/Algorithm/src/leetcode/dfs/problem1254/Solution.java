package leetcode.dfs.problem1254;

public class Solution {

    int[] directions = {-1, 0, 1, 0, -1};
    int[][] grid;
    int m;
    int n;
   boolean[][] visited;

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && grid[0][i] == 0) {
                dfs(0, i);
            }
            if (!visited[m - 1][i] && grid[m - 1][i] == 0) {
                dfs(m - 1, i);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (!visited[i][0] && grid[i][0] == 0) {
                dfs(i, 0);
            }
            if (!visited[i][n - 1] && grid[i][n - 1] == 0) {
                dfs(i, n - 1);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    ++count;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int x = r + directions[i];
            int y = c + directions[i + 1];
            if (x >= 0 && y >=0 && x < m && y < n && !visited[x][y] && grid[x][y] == 0) {
                dfs(x, y);
            }
        }
    }
}
