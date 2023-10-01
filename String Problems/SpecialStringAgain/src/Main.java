import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(substrCountPalindromicSubstrings(7, "abcbaba"));
    }

    private static long substrCountPalindromicSubstrings(int n, String s){ // works but not performatic..
        if (n == 1) {
            return 1L;
        }

        long count = 0;
        for(int i = 0; i < s.length(); i++) {
            String substring = "";
            for(int j = i ; j < s.length(); j++){
                substring += s.charAt(j);
                if (isPalindromicWithoutStack(substring)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalindromicWithoutStack(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] string = s.toCharArray();

        if (string.length % 2 == 0) { // even
            for(int i = 0; i < string.length; i++) {

                if (start >= end) {
                    break;
                }

                if (string[start] != string[end]) {
                    return false;
                }

                start++;
                end--;
            }
            return true;
        } else {         // odd
            int middle = string.length / 2;

            for (int i = 0; i < middle; i++){
                if (string[i] != string[(middle+1)+i]) {
                    return false;
                }
            }

            return true;
        }
    }

    private static boolean isPalindromicWithStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character ch: s.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while(!stack.isEmpty()){
            Character ch = stack.pop();
            reversed += ch.toString();
        }


        if (s.equals(reversed) && s.length() % 2 != 0) { // isEven
            int middle = s.length() / 2;
            for (int i = 0; i < middle; i++){
                if (reversed.charAt(i) != reversed.charAt((middle+1)+i)) {
                    return false;
                }
            }
        }

        return s.equals(reversed);
    }
}