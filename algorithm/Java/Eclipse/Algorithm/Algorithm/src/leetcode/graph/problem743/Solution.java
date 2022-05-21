package leetcode.graph.problem743;

import java.util.Arrays;

public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < times.length; i++) {
            adj[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }
        boolean[] visited = new boolean[n];
        int[] minDistance = new int[n];
        for (int i = 0; i < n; i++) {
            minDistance[i] = adj[k - 1][i];
        }
        minDistance[k - 1] = 0;
        visited[k - 1] = true;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && min > minDistance[j]) {
                    min = minDistance[j];
                    index = j;
                }
            }
            if (min == Integer.MAX_VALUE) {
                return -1;
            }
            visited[index] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && adj[index][j] != Integer.MAX_VALUE && min + adj[index][j] < minDistance[j]) {
                    minDistance[j] = min + adj[index][j];
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(minDistance[i], maxTime);
        }
        return maxTime;
    }

}