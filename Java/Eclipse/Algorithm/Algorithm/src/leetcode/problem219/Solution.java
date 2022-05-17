package leetcode.problem219;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                hashMap.put(nums[i], arrayList);
            } else {
                ArrayList<Integer> arrayList = hashMap.get(nums[i]);
                for (int num : arrayList) {
                    if (Math.abs(num - i) <= k) {
                        return true;
                    }
                }
                arrayList.add(i);
            }
        }
        return false;
    }
}