package leetcode.binarysearch.problem69;

public class Solution2 {
    public int mySqrt(int x) {
        long a = x;
        while (a * a > x) {
            a = ((a + x / a) >> 1);
        }
        return (int) a;
    }
}
