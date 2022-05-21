package leetcode.dfs.problem785;

public class Solution {

    int[][] graph;
    int[] colors;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        this.graph = graph;
        int n = graph.length;
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

    public boolean dfs(int from, int color) {
        visited[from] = true;
        colors[from] = color;
        for (int next : graph[from]) {
            if (!visited[next]) {
                if (!dfs(next, 1 - color)) {
                    return false;
                }
            } else if (color == colors[next]) {
                return false;
            }
        }
        return true;
    }
}