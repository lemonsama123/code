package leetcode.sort.problem493;

public class Solution {
	
	int[] temp;
	
	public int reversePairs(int[] nums) {
		temp = new int[nums.length];
		return mergeSort(nums, 0, nums.length - 1);
	}
	
	int mergeSort(int[] nums, int l, int r) {
    	if (l >= r) {
    		return 0;
    	}
    	int res = 0;
    	int mid = (l + r) >> 1;
    	res += (mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r));
    	int k = 0;
    	int i = l;
    	int j = mid + 1;
    	while (i <= mid && j <= r) {
    		if (nums[i] > 2 * nums[j]) {
    			res += (mid - i + 1);
    		}
    		if (nums[i] <= nums[j]) {
    			temp[k++] = nums[i++];
    		} else {
    			temp[k++] = nums[j++];
    		}
    	}
    	while (i <= mid) {
    		temp[k++] = nums[i++];
    	}
    	while (j <= r) {
    		temp[k++] = nums[j++];
    	}
    	for (i = l, j = 0; i <= r; ++i, ++j) {
    		nums[i] = temp[j];
    	}
    	return res;
    }
}
