package leetcode.dfs.problem886;

import java.util.HashSet;

public class Solution {

    HashSet<Integer>[] adj;
    int[] colors;
    boolean[] visited;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n <= 0) {
            return false;
        }
        adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] edge : dislikes) {
            adj[edge[0] - 1].add(edge[1] - 1);
            adj[edge[1] - 1].add(edge[0] - 1);
        }
        colors = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int cur, int color) {
        colors[cur] = color;
        visited[cur] = true;
        for (int next : adj[cur]) {
            if (!visited[next]) {
                if (!dfs(next, 1 - color)) {
                    return false;
                }
            } else if (colors[next] == color) {
                return false;
            }
        }
        return true;
    }
}