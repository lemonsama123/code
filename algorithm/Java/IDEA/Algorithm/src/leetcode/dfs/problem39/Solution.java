package leetcode.dfs.problem39;

import java.util.*;

public class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> cur = new LinkedList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0 || candidates == null || candidates.length == 0) {
            return ans;
        }
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        backtracking(0, target);
        return ans;
    }

    public void backtracking(int curIndex, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = curIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            cur.addLast(candidates[i]);
            backtracking(i, target - candidates[i]);
            cur.removeLast();
        }
    }
}
