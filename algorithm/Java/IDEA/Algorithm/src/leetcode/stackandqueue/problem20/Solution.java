package leetcode.stackandqueue.problem20;


import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if ((s.length() & 1) != 0) {
            return false;
        }
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != hashMap.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

