import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main (String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    private static int lengthOfLongestSubstring(String s) {

        String longestSubstring = "";
        String [] splitted = s.split("");
        Map<String, String> dic = new HashMap<>();

        for (String c: splitted) {
            String actualSubstring = dic.get(c);

            if (actualSubstring != null) {
                if (actualSubstring.indexOf(c) == -1) {
                    actualSubstring += c;
                    dic.put(c, actualSubstring);
                } else {
                    longestSubstring = actualSubstring;
                }
            } else {
                dic.put(c, c);
            }

        }

        return longestSubstring.length();
    }
}
