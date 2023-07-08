import java.util.Stack;

public class StringPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindrome(String s) { //O(n)
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        System.out.println(s);
        if (s == "") return true;

        // return isPalindromeByStack(s);
        return isPalindromeByWindowSliding(s);
    }

    private static boolean isPalindromeByWindowSliding(String s) {
        int i = 0, j = s.length()-1;

        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private static boolean isPalindromeByStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) { //O(n)
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) { //O(n)
            Character symbol = stack.pop();

            if (!symbol.equals(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
