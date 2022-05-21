package leetcode.bitarithmetic.problem405;

public class Solution {
    public String toHex(int num) {
       if (num == 0) {
           return "0";
       }
       StringBuilder ans = new StringBuilder();
        for (int i = 7; i >=0 ; --i) {
            int val = (num >> 4 * i) & (0xf);
            if (ans.length() > 0 || val > 0) {
                if (val < 10) {
                    ans.append(val);
                } else {
                    ans.append((char) (val - 10 + 'a'));
                }
            }
        }
        return ans.toString();
    }
}