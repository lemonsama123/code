package leetcode.bfs.problem417;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[] canRanchPacific = new boolean[m * n];
        boolean[] canRanchAtlantic = new boolean[m * n];
        for (int i = 0; i < n; i++) {
            bfs(heights, canRanchPacific, 0, i);
            bfs(heights, canRanchAtlantic, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            bfs(heights, canRanchPacific, i, 0);
            bfs(heights, canRanchAtlantic, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canRanchPacific[i * n + j] && canRanchAtlantic[i * n + j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static final int[] help = {-1, 0, 1, 0, -1};

    public void bfs(int[][] heights, boolean[] can, int x, int y) {
        int m = heights.length;
        int n = heights[0].length;
        can[x * n + y] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * n + y);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int x1 = poll / n;
            int y1 = poll % n;
            for (int i = 0; i < 4; i++) {
                int r = x1 + help[i];
                int c = y1 + help[i + 1];
                if (r >= 0 && c >= 0 && r < m && c < n && heights[r][c] >= heights[x1][y1] && !can[r * n + c]) {
                    queue.add(r * n + c);
                    can[r * n + c] = true;
                }
            }
        }
    }
}