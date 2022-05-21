package leetcode.bfs.problem200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public final static int[] help = {-1, 0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i * n + j]) {
                    bfs(grid, i, j, visited);
                    ++ans;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int x, int y, boolean[] visited) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * n + y);
        visited[x * n + y] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int x1 = poll / n;
            int y1 = poll % n;
            for (int i = 0; i < 4; i++) {
                int r = x1 + help[i];
                int c = y1 + help[i + 1];
                if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1' && !visited[r * n + c]) {
                    queue.add(r * n + c);
                    visited[r * n + c] = true;
                }
            }
        }
    }
}



