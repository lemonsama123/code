package leetcode.dp.problem152;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
//        int[] maxF = new int[n];
//        int[] minF = new int[n];
//        maxF[0] = nums[0];
//        minF[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            maxF[i] = max(maxF[i - 1] * nums[i], minF[i - 1] * nums[i], nums[i]);
//            minF[i] =  min(maxF[i - 1] * nums[i], minF[i - 1] * nums[i], nums[i]);
//        }
//        int ans = maxF[0];
//        for (int i = 1; i < n; i++) {
//            ans = Math.max(ans, maxF[i]);
//        }
//        return ans;
        int preMax = nums[0];
        int preMin = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; ++i) {
            int pMax = preMax;
            int pMin = preMin;
            preMax = Math.max(Math.max(pMax * nums[i], pMin * nums[i]), nums[i]);
            preMin = Math.min(Math.min(pMax * nums[i], pMin * nums[i]), nums[i]);
            ans = Math.max(ans, preMax);
        }
        return ans;
    }
}
