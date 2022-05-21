package leetcode.bfs.problem1034;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    int m;
    int n;
    int[] help = {-1, 0, 1, 0, -1};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        bfs(grid, row, col, color, grid[row][col]);
        return grid;
    }

    public void bfs(int[][] grid, int row, int col, int color, int oldColor) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> borders = new ArrayList<>();
        boolean[] visited = new boolean[m * n];
        queue.add(row * n + col);
        visited[row * n + col] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int x = poll / n;
            int y = poll % n;
            boolean isBorder = false;
            for (int i = 0; i < 4; i++) {
                int r = x + help[i];
                int c = y + help[i + 1];
                if (!(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == oldColor)) {
                    isBorder = true;
                } else if (!visited[r * n + c]) {
                    visited[r * n + c] = true;
                    queue.offer(r * n + c);
                }
            }
            if (isBorder) {
                borders.add(x * n + y);
            }
        }
        for (int border : borders) {
            int x = border / n;
            int y = border % n;
            grid[x][y] = color;
        }
    }
}