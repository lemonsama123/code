package leetcode.dfs.problem1136;

import java.util.HashSet;

//FIXME: 错误的
public class Solution1 {

    HashSet<Integer>[] adj;
    int[] visited;
    int ans = 0;

    public int minimumSemesters(int n, int[][] relations) {
        if (n <= 0) {
            return -1;
        }
        adj = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new HashSet<>();
        }
        for (int[] edge : relations) {
            adj[edge[1] - 1].add(edge[0 - 1]);
        }
        visited = new int[n];
        for (int i = 0; i < n; ++i) {
            if (dfs(i)) {
                return -1;
            }
        }
        return ans;
    }

    public boolean dfs(int cur) {
        if (visited[cur] == 1) {
            return true;
        }
        if (visited[cur] == 2) {
            return false;
        }
        visited[cur] = 1;
        for (int next : adj[cur]) {
            if (dfs(next)) {
                return true;
            }
        }
        ++ans;
        visited[cur] = 2;
        return false;
    }
}