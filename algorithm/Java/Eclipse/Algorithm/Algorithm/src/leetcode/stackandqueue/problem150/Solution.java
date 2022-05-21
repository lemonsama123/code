package leetcode.stackandqueue.problem150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
           if ("+".equals(token)) {
               stack.push(stack.pop() + stack.pop());
           } else if ("-".equals(token)) {
               int val1 = stack.pop();
               int val2 = stack.pop();
               stack.push(val2 - val1);
           } else if ("*".equals(token)) {
               stack.push(stack.pop() * stack.pop());
           } else if ("/".equals(token)) {
               int val1 = stack.pop();
               int val2 = stack.pop();
               stack.push(val2 / val1);
           } else {
               stack.push(Integer.valueOf(token));
           }
        }
        return stack.pop();
    }
}