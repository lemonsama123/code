package leetcode.bitarithmetic.problem260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        int rightOne = eor & (-eor);
        int a = 0;
        for (int num : nums) {
            if ((num & rightOne) != 0) {
                a ^= num;
            }
        }
        return new int[]{a, a ^ eor};
    }
}