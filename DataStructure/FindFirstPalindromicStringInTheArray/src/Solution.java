import java.util.Stack;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n) - linear on higher word on []words

 * With stack implementation
 * With stringBuilder implementation
 * 
 * if i dont want to use a additional space to do this.. i can compare a word.charAt(i) in loop instead 
 * 
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
 */
class Solution {
    public String firstPalindrome(String[] words) {
        // loop throught array // O(n)
        // apply a palindromic algorithm for each word // O(n)

        for (String word: words) { 
            int wordLength = word.length();
            if (!word.substring(0, 1).equals(word.substring(wordLength - 1))) {
                continue;
            }

            if (isPalindromic(word)) {
                return word;
            }
            // StringBuilder str = new StringBuilder(word); // also works but uses a StringBuilder java class
            // if (str.reverse().toString().equals(word)) {
            //     return word;
            // }
        }

        return "";
    }


    private boolean isPalindromic(String word) {
        Stack<Character> stack = new Stack<>();

        for(Character ch: word.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while(!stack.isEmpty()) {
            Character ch = stack.pop();
            reversed += ch.toString();
        }

        return word.equals(reversed);
    }
}