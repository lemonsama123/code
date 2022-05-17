package leetcode.tree.problem220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                hashMap.put(nums[i], arrayList);
            } else {
                Set<Integer> keys = hashMap.keySet();
                for (int key : keys) {
                    if (Math.abs(key - nums[i]) <= t) {
                        ArrayList<Integer> arrayList = hashMap.get(key);
                        for (int num : arrayList) {
                            if (Math.abs(num - i) <= k) {
                                return true;
                            }
                        }
                    }
                }
                ArrayList<Integer> arrayList = hashMap.get(nums[i]);
                arrayList.add(i);
                hashMap.put(nums[i], arrayList);
            }
        }
        return false;
    }
}