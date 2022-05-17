package leetcode.stackandqueue.problem946;

import java.util.Stack;

public class Solution1 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && i < popped.length && stack.peek() == popped[i]) {
                stack.pop();
                ++i;
            }
        }
        return i == popped.length;
    }
}

