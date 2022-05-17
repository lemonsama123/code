package leetcode.dp.problem1173;

import java.util.stream.IntStream;

public class Solution2 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] ans = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] m = {{0, 0, 1}, {1, 0, 1}, {0, 1, 1}};
        n -= 3;
        while (n != 0) {
            if ((n & 1) != 0) {
                ans = multiply(ans, m);
            }
            n >>= 1;
            m = multiply(m, m);
        }
        return IntStream.of(ans[1]).sum() + IntStream.of(ans[2]).sum();
    }

    public int[][] multiply(int[][] m1, int[][] m2) {
        return new int[][]{
                {
                        m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0] + m1[0][2] * m2[2][0],
                        m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1] + m1[0][2] * m2[2][1],
                        m1[0][0] * m2[0][2] + m1[0][1] * m2[1][2] + m1[0][2] * m2[2][2]
                },
                {
                        m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0] + m1[1][2] * m2[2][0],
                        m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1] + m1[1][2] * m2[2][1],
                        m1[1][0] * m2[0][2] + m1[1][1] * m2[1][2] + m1[1][2] * m2[2][2]
                },
                {
                        m1[2][0] * m2[0][0] + m1[2][1] * m2[1][0] + m1[2][2] * m2[2][0],
                        m1[2][0] * m2[0][1] + m1[2][1] * m2[1][1] + m1[2][2] * m2[2][1],
                        m1[2][0] * m2[0][2] + m1[2][1] * m2[1][2] + m1[2][2] * m2[2][2]
                }
        };
    }
}