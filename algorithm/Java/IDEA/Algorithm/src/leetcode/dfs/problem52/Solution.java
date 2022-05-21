package leetcode.dfs.problem52;

public class Solution {

    int n;
    int ans;
    boolean[] col;
    boolean[] diagonal;
    boolean[] subdiagonal;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return n;
        }
        this.n = n;
        col = new boolean[n];
        diagonal = new boolean[2 * n - 1];
        subdiagonal = new boolean[2 * n - 1];
        backtracking(0);
        return ans;
    }

    public void backtracking(int row) {
        if (row == n) {
            ++ans;
        }
        for (int i = 0; i < n; ++i) {
            if (col[i] || diagonal[row - i + n - 1] || subdiagonal[row + i]) {
                continue;
            }
            col[i] = true;
            diagonal[row - i + n - 1] = true;
            subdiagonal[row + i] = true;
            backtracking(row + 1);
            col[i] = false;
            diagonal[row - i + n - 1] = false;
            subdiagonal[row + i] = false;
        }
    }
}