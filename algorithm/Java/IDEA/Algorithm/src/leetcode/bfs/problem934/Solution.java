package leetcode.bfs.problem934;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int m;
    int n;
    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }
        return bfs(grid, queue);
    }

    private static final int[] help = {-1, 0, 1, 0, -1};
    public void dfs(int[][] grid, int i, int j, Queue<Integer> queue) {
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] == 0) {
            queue.add(i * n + j);
            return;
        }
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + help[k], j + help[k + 1], queue);
        }
    }

    public int bfs(int[][] grid, Queue<Integer> queue) {
        int leave = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            leave++;
            while (curSize-- != 0) {
                int poll = queue.poll();
                int x = poll / n;
                int y = poll % n;
                for (int i = 0; i < 4; i++) {
                    int r = x + help[i];
                    int c = y + help[i + 1];
                    if (r >= 0 && c >= 0 && r < m && c < n) {
                        if (grid[r][c] == 2) {
                            continue;
                        }  if (grid[r][c] == 1) {
                            return leave;
                        }
                        grid[r][c] = 2;
                        queue.add(r * n + c);
                    }
                }
            }
        }
        return leave;
    }
}