package leetcode.graph.problem797;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return ans;
        }
        dfs(graph, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(int[][] adj, int node, List<Integer> path, List<List<Integer>> ans) {
        path.add(node);
        if (node == adj.length - 1) {
            ans.add(new ArrayList<>(path));
        }
        for (int next : adj[node]) {
            dfs(adj, next, path, ans);
            path.remove(path.size() - 1);
        }
    }
}