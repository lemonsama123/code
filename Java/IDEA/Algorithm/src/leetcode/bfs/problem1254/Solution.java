package leetcode.bfs.problem1254;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int m;
    int n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < n; i++) {
            bfs(grid, 0, i);
            bfs(grid, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            bfs(grid, i, 0);
            bfs(grid, i, n - 1);
        }
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    int[] help = {-1, 0, 1, 0, -1};
    public void bfs(int[][] grid, int x, int y) {
        if (grid[x][y] != 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * n + y);
        grid[x][y] = 1;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int tx = poll / n;
            int ty = poll % n;
            for (int i = 0; i < 4; i++) {
                int r = tx + help[i];
                int c = ty + help[i + 1];
                if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 0) {
                    queue.add(r * n + c);
                    grid[r][c] = 1;
                }
            }
        }
    }
}