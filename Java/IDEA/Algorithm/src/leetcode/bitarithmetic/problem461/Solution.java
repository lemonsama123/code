package leetcode.bitarithmetic.problem461;

public class Solution {
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        y = 0;
        while (x != 0) {
            x &= (x - 1);
            ++y;
        }
        return y;
    }
}