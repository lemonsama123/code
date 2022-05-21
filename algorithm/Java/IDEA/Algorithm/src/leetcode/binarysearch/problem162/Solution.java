package leetcode.binarysearch.problem162;

public class Solution {
    public int findPeakElement(int[] nums) {
       int left = 0;
       int right = nums.length - 1;
       while (left < right) {
           int mid = ((right - left) >> 1) + left;
           if (nums[mid] > nums[mid + 1]) {
               right = mid;
           } else {
               left = mid + 1;
           }
       }
       return left;
    }
}
