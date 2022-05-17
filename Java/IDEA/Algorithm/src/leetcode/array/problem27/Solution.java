package leetcode.array.problem27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        while (fast < n) {
            
          if (nums[slow] != val) {
              slow++;
          }
          ++fast;
        }
        return n;
    }
}