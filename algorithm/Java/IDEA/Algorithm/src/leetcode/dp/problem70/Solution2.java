package leetcode.dp.problem70;

public class Solution2 {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        n -= 3;
        int[][] ans = {{1, 0}, {0, 1}};
        int[][] m = {{0, 1}, {1, 1}};
        while (n != 0) {
            if ((n & 1) != 0) {
                ans = multiply(ans, m);
            }
            m = multiply(m, m);
            n >>= 1;
        }
        return ans[0][0] + ans[0][1] + 2 * (ans[1][0] + ans[1][1]);
    }

    public int[][] multiply(int[][] m1, int[][] m2) {
        return new int[][]{
                {
                        m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0],
                        m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]
                },
                {
                        m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0],
                        m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]
                }
        };
    }
}