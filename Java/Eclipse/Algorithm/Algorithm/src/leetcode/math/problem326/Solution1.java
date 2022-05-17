package leetcode.math.problem326;

public class Solution1 {
    public boolean isPowerOfThree(int n) {
       return n > 0 && 0x4546b3db % n == 0;
    }
}