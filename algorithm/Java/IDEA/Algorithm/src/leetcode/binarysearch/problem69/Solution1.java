package leetcode.binarysearch.problem69;


public class Solution1 {

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            long mid = ((right - left) >> 1) + left;
            if (mid * mid > x) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }
        return right;
    }
}