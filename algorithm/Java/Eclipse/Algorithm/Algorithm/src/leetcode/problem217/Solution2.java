package leetcode.problem217;

import java.util.HashSet;

public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
       HashSet<Integer> hashSet = new HashSet<>();
       for (int num : nums) {
           if (hashSet.contains(num)) {
               return true;
           }
           hashSet.add(num);
       }
       return false;
    }
}
