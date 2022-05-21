package leetcode.dfs.problem207;

import java.util.HashSet;

public class Solution {

    HashSet<Integer>[] adj;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       if (numCourses <= 0) {
           return true;
       }
       adj = new HashSet[numCourses];
       for (int i = 0; i < numCourses; ++i) {
           adj[i] = new HashSet<>();
       }
       for (int i = 0; i < prerequisites.length; ++i) {
           adj[prerequisites[i][0]].add(prerequisites[i][1]);
       }
       visited = new int[numCourses];
       for (int i = 0; i < numCourses; ++i) {
           if (dfs(i)) {
               return false;
           }
       }
       return true;
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
        return false;
    }
}