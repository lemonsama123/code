package leetcode.dfs.problem210;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    HashSet<Integer>[] adj;
    int[] visited;
    List<Integer> ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[]{};
        }
        adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        visited = new int[numCourses];
        ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i)) {
                return new int[]{};
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
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
        visited[cur] = 2;
        ans.add(cur);
        return false;
    }
}
