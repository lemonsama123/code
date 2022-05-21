package leetcode.bitarithmetic.problem504;

public class Solution2 {
    public String convertToBase7(int num) {
        int i = 1;
        int ans = 0;
        while (num != 0) {
            ans += num % 7 * i;
            num /= 7;
            i *= 10;
        }
        return Integer.toString(ans);
    }
}
