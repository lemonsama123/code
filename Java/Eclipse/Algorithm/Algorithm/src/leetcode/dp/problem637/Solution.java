package leetcode.dp.problem637;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
          dp[0][i] = 1;
          dp[1][i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[0][i] < dp[0][j] + 1) {
                        dp[0][i] = dp[0][j] + 1;
                        dp[1][i] = dp[1][j];
                    } else if (dp[0][i] == dp[0][j] + 1) {
                        dp[1][i] += dp[1][j];
                    }
                }
            }
            max = Math.max(max, dp[0][i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[0][i] == max) {
                ans += dp[1][i];
            }
        }
        return ans;
    }
}