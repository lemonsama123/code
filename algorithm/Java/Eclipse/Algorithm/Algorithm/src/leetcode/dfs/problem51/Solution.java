package leetcode.dfs.problem51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    int n;
    List<List<String>> ans;
    boolean[] col;
    boolean[] diagonal;
    boolean[] subdiagonal;
    char[][] word;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        this.n = n;
        col = new boolean[n];
        diagonal = new boolean[2 * n - 1];
        subdiagonal = new boolean[2 * n - 1];
        word = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(word[i], '.');
        }
        backtracking(0);
        return ans;
    }

    public void backtracking(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < word.length; ++i) {
                list.add(new String(word[i]));
            }
            ans.add(list);
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || diagonal[n - row + i - 1] || subdiagonal[row + i]) {
                continue;
            }
            word[row][i] = 'Q';
            col[i] = true;
            diagonal[n - row + i - 1] = true;
            subdiagonal[row + i] = true;
            backtracking(row + 1);
            word[row][i] = '.';
            col[i] = false;
            diagonal[n - row + i - 1] = false;
            subdiagonal[row + i] = false;
        }
    }
}