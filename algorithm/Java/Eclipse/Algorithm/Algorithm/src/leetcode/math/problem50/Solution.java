package leetcode.math.problem50;

public class Solution {
    public double myPow(double x, int n) {
        boolean isNeg = n < 0;
        n = Math.abs(n);
        double ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                ans *= x;
            }
            x *= x;
            n >>>= 1;
        }
        System.out.println(ans);
        return isNeg ? 1 / ans : ans;
    }
}