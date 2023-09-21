public class Main {
    public static void main(String[] args) {
        System.out.println(makeAnagram("abcdea", "abcdf"));
    }

    public static int makeAnagram(String a, String b) {
        // Write your code here
        // abcdea
        // abcdf
        // a b c d e f
        // 2 1 1 1 1 0 <- frequency / histogram of abcde
        // 1 1 1 1 0 1 <- frequency / histogram of abcdf
        // ------------
        // 1 0 0 0 1 1 = 3 letters to be deleted

        int [] histogramOfA = new int[26];
        int [] histogramOfB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            histogramOfA[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            histogramOfB[b.charAt(i) - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(histogramOfA[i] - histogramOfB[i]);
        }

        return result;
    }
}