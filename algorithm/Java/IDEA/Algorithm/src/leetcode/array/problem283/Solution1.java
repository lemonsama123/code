package leetcode.array.problem283;

public class Solution1 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int t = nums[right];
                nums[right] = nums[left];
                nums[left] = t;
                ++left;
            }
            ++right;
        }
    }
}