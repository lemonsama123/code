package leetcode.bfs.problem695;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static final int[] help = {-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i * n + j]) {
                    max = Math.max(max, bfs(grid, i, j, visited));
                }
            }
        }
        return max;
    }

    public int bfs(int[][] grid, int x, int y, boolean[] visited) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * n + y);
        visited[x * n + y] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int curX = poll / grid[0].length;
            int curY = poll % grid[0].length;
            count++;
            for (int i = 0; i < 4; i++) {
                int r = curX + help[i];
                int c = curY + help[i + 1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && !visited[r * n + c]) {
                    queue.add(r * n + c);
                    visited[r * n + c] = true;
                }
            }
        }
        return count;
    }
}