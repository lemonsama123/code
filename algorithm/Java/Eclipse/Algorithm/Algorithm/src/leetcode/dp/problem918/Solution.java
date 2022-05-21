package leetcode.dp.problem918;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int minSum = nums[0];
       int maxSum = nums[0];
       int total = 0;
       for (int num : nums) {
           int curMax = maxSum;
           int curMin = minSum;
           maxSum = Math.max(maxSum, num + curMax);
           minSum = Math.min(minSum, num + curMin);
           total += num;
       }
       return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}