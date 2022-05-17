package leetcode.dfs.problem802;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    int[] color;
    int[][] graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        this.graph = graph;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (dfs(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int x) {
        if (color[x] != 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!dfs(y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}
    