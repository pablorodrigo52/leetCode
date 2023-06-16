import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-2147447412));
    }

    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            stack.push(number.charAt(i));
        }

        for (int i = 0; i < number.length(); i++) {
            Character symbol = stack.pop();

            if (!symbol.equals(number.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
