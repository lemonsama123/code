package leetcode.dfs.problem22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> ans = new ArrayList<>();
    StringBuilder cur = new StringBuilder();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtracking(0, 0);
        return ans;
    }

    public void backtracking(int open, int close) {
        if (cur.length() == 2 * n) {
            ans.add(cur.toString());
        }
        if (open < n) {
            cur.append('(');
            backtracking(open + 1, close);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtracking(open, close + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}