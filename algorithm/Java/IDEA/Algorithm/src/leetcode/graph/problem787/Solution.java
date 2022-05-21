package leetcode.graph.problem787;

import java.util.Arrays;

/**
 * Bellman Ford Algorithm
 */

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (dst == src) {
            return 0;
        }
        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);
        dp[0][src] = 0;
        for (int i = 0; i <= k + 1; ++i) {
            dp[i & 1][src] = 0;
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                if (dp[(i - 1) & 1][from] != Integer.MAX_VALUE) {
                    dp[i & 1][to] = Math.min(dp[i & 1][to], dp[(i - 1) & 1][from] + cost);
                }
            }
        }
        return dp[(k - 1) & 1][dst] == Integer.MAX_VALUE ? -1 : dp[(k - 1) & 1][dst];
    }
}