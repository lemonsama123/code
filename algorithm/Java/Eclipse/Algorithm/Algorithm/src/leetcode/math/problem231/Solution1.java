package leetcode.math.problem231;

public class Solution1 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}