package leetcode.dfs.problem417;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    int[] directions = {-1, 0, 1, 0, -1};
    List<List<Integer>> ans = new ArrayList<>();
    int[][] heights;
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return ans;
        }
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (!canReachPacific[0][i]) {
                dfs(0, i, canReachPacific);
            }
            if (!canReachAtlantic[m - 1][i]) {
                dfs(m - 1, i, canReachAtlantic);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!canReachPacific[i][0]) {
                dfs(i, 0, canReachPacific);
            }
            if (!canReachAtlantic[i][n - 1]) {
                dfs(i, n - 1, canReachAtlantic);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public void dfs(int r, int c, boolean[][] canReach) {
        canReach[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int x = r + directions[i];
            int y = c + directions[i + 1];
            if (x >= 0 && y >= 0 && x < m && y < n && heights[x][y] >= heights[r][c] && !canReach[x][y]) {
                dfs(x, y, canReach);
            }
        }
    }
}