public class LinearSolution {

    public static void main (String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    private static int lengthOfLongestSubstring(String s) {
        
        String p = "";
        int maxLength = 0;

        for (char c : s.toCharArray()) {
            String letter = String.valueOf(c);

            if (p.indexOf(letter) >= 0) {
                p = p.substring(p.indexOf(letter) + 1);              
            }
            
            p = p + letter;
            maxLength = Math.max(p.length(), maxLength);
        }

        return maxLength;
    }
}
