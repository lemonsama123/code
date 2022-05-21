package leetcode.bfs.problem323;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    List<Integer>[] adj;
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ++count;
                dfs(i);
            }
        }
        return 0;
    }

    public void dfs(int i) {
        visited[i] = true;
        List<Integer> next = adj[i];
        for (int n : next) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}