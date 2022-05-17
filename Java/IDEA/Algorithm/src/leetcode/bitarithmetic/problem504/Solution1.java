package leetcode.bitarithmetic.problem504;

public class Solution1 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNeg = num < 0;
        num = Math.abs(num);
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            ans.insert(0, num % 7);
            num /= 7;
        }
        if (isNeg) {
            ans.insert(0 , '-');
        }
        return ans.toString();
    }
}