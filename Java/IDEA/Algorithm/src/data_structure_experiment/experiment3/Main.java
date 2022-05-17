package data_structure_experiment.experiment3;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String infix = "a+b*(c-d)/e";
        String suffix = infixToSuffix(infix);
        System.out.println(suffix);
    }

    // 中缀表达式转后缀
    public static String infixToSuffix(String infix) {
        String suffix = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    suffix += stack.pop();
                }
                stack.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    suffix += stack.pop();
                }
                stack.push(c);
            } else {
                suffix += c;
            }
        }
        while (!stack.isEmpty()) {
            suffix += stack.pop();
        }
        return suffix;
    }

    public static int priority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}
