package leetcode.dfs.problem46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

        List<List<Integer>> ans;
        int[] nums;

        public List<List<Integer>> permute(int[] nums) {
            ans = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return ans;
            }
            this.nums = nums;
            backtracking(0);
            return ans;
        }

        public void backtracking(int cur) {
            if (cur == nums.length) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums) {
                    list.add(num);
                }
                ans.add(list);
            }
            for (int i = cur; i < nums.length; ++i) {
                int temp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = temp;
                backtracking(cur + 1);
                temp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = temp;
            }
        }
    }