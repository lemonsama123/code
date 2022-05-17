package leetcode.dfs.problem802;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    Boolean[] visited;
    int[][] graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return ans;
        }
        this.graph = graph;
        int n = graph.length;
        visited = new Boolean[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int from) {
        if (visited[from] != null) {
            return visited[from];
        }
        visited[from] = true;
        for (int next : graph[from]) {
            if (dfs(next)) {
                return true;
            }
        }
        visited[from] = false;
        return false;
    }
}
