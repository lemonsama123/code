package leetcode.array.problem26;

public class Solution1 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int pre = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                nums[j] = nums[i];
                pre = nums[j];
                ++j;
            }
        }
        return j;
    }
}
