import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world"));
    }


    public static String twoStrings(String s1, String s2) {
        // Write your code here
        Set<String> setS1 = getSubstrings(s1);
        Set<String> setS2 = getSubstrings(s2);


        for (String s : setS1) { // O(n^2)
            if (setS2.contains(s)) {
                return "YES";
            }
        }

        return "NO";
    }


    private static Set<String> getSubstrings(String s) { // O(n)
        final Set<String> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            String substring = "";
            for(int j = i; j < s.length(); j++) {
                substring += s.charAt(j);
                set.add(substring);
            }
        }

        return set;
    }
}