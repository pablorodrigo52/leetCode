import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // "" -> not valid
        // () -> valid
        // ({}) -> valid
        // ({)} -> not valid
        // ){} -> not valid
        // {123()} -> not valid

        if (s == null || s.equals("")) {
            return false;
        }

        if (s.startsWith(")") || s.startsWith("}") || s.startsWith("]")) {
            return false;
        }

        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (Character bracket: brackets) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            Character stackFirstElement = stack.peek();

            if (bracket == ')' && stackFirstElement == '(' ) {
                stack.pop();
                continue;
            }

            if (bracket == '}' && stackFirstElement == '{' ) {
                stack.pop();
                continue;
            }

            if (bracket == ']' && stackFirstElement == '[' ) {
                stack.pop();
                continue;
            }

            return false;
        }

        return stack.isEmpty();
    }
}
