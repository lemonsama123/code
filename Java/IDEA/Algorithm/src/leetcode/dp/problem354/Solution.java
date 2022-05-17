package leetcode.dp.problem354;

import java.util.Arrays;

public class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (envelope1, envelope2) -> {
            if (envelope1[0] < envelope2[0]) {
                return -1;
            } else if (envelope1[0] > envelope2[0]) {
                return 1;
            } else {
               if (envelope1[1] < envelope2[1]) {
                   return -1;
               } else if (envelope1[1] > envelope2[1]) {
                   return 1;
               } else {
                   return 0;
               }
            }
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 1;
        for (int n : dp) {
            ans = Math.max(ans, n);
        }
        return ans;
    }
}