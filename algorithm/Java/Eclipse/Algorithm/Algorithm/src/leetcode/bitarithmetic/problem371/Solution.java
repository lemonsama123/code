package leetcode.bitarithmetic.problem371;

class Solution {
    public int getSum(int a, int b) {
     int ans = 0;
     int carray = 0;
        for (int i = 0; i < 32; i++) {
            int f1 = (a >>> i) & 1;
            int f2 = (b >>> i) & 1;
            if (f1 == 1 && f2 == 1) {
                ans |= carray << i;
                carray = 1;
            } else if (f1 == 1 || f2 == 1) {
                ans |= (1 ^ carray) << i;
            } else {
                ans |= carray << i;
                carray = 0;
            }
        }
     return ans;
    }
}