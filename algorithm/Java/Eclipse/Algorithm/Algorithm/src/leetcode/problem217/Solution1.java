package leetcode.problem217;

import java.util.Arrays;

public class Solution1 {
    public boolean containsDuplicate(int[] nums) {
     Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
