package leetcode.dp.problem509;

public class Solution2 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        n -= 3;
        int[][] ans = {{1, 0}, {0, 1}};
        int[][] m = {{0, 1}, {1, 1}};
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = multiply(ans, m);
            }
            n >>= 1;
            ans = multiply(ans, ans);
        }
        return ans[1][0] + ans[1][1];
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