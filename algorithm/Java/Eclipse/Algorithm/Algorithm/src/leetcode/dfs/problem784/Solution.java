package leetcode.dfs.problem784;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> ans = new ArrayList<>();
    char[] str;

    public List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0) {
            return ans;
        }
        str = s.toCharArray();
        backtracking(0);
        return ans;
    }

    public void backtracking(int curIndex) {
        if (curIndex == str.length) {
            ans.add(new String(str));
            return;
        }
        if ('a' <= str[curIndex] && str[curIndex] <= 'z') {
            backtracking(curIndex + 1);
            str[curIndex] = (char) (str[curIndex] - ('a' - 'A'));
            backtracking(curIndex + 1);
            str[curIndex] = (char) (str[curIndex] + ('a' - 'A'));
        } else if ('A' <=str[curIndex] && str[curIndex] <= 'Z') {
            backtracking(curIndex + 1);
            str[curIndex] = (char) (str[curIndex] + ('a' - 'A'));
            backtracking(curIndex + 1);
            str[curIndex] = (char) (str[curIndex] - ('a' - 'A'));
        } else {
            backtracking(curIndex + 1);
        }
    }
}