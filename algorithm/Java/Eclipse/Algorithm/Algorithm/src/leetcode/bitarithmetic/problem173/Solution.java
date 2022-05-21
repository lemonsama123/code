package leetcode.bitarithmetic.problem173;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
       HashMap<Integer, Integer> hashMap = new HashMap<>();
       for (int num : nums) {
           hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
       }
       for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
           if (entry.getValue() == 1)  {
               return entry.getKey();
           }
       }
       return -1;
    }
}