package leetcode.bfs.problem1020;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int m;
    int n;
    public int numEnclaves(int[][] grid) {
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += bfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    int[] help = {-1, 0, 1, 0, -1};

    public int bfs(int[][] grid, int x, int y) {
        if (grid[x][y] != 1) {
            return 0;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * n + y);
        grid[x][y] = 0;
        while (!queue.isEmpty()) {
            count++;
            int poll = queue.poll();
            int tx = poll / n;
            int ty = poll % n;
            for (int i = 0; i < 4; i++) {
                int r = tx + help[i];
                int c = ty + help[i + 1];
                if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                    queue.add(r * n + c);
                    grid[r][c] = 0;
                }
            }
        }
        return count;
    }
}
