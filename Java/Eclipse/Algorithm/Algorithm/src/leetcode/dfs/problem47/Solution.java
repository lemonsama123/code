package leetcode.dfs.problem47;

import java.util.*;

public class Solution {

    int[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> cur = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        this.nums = nums;
        backtracking(0);
        return ans;
    }
    public void backtracking(int curIndex) {
        if (curIndex == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            cur.addLast(nums[i]);
            backtracking(curIndex + 1);
            used[i] = false;
            cur.removeLast();
        }
    }
}