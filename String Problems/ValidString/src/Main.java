public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("aabbcd")); // NO
        System.out.println(isValid("aabbccddeefghi")); // NO
        System.out.println(isValid("abcdefghhgfedecba")); // YES
        System.out.println(isValid("abbccc")); // NO
    }

    private static int[] getFrequency(String s) {
        int [] frequency = new int[26];

        for(int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        return frequency;
    }

    private static String isValid(String s) {
        int [] frequency = getFrequency(s);

        int maxFrequency = -1;
        boolean removedChar = false;
        for (int i = 0; i < 26; i++) {
            if(frequency[i] == 0) { // character not appears on string
                continue;
            }

            if(maxFrequency == -1) { // find first frequency
                maxFrequency = frequency[i];
                continue;
            }

            if(frequency[i] == maxFrequency) { // has same frequency
                continue;
            }

            if(!removedChar && (frequency[i] >= maxFrequency + 1 || frequency[i] == 1)) { // has diff frequency but at least frequency + 1
                removedChar = true;
                continue;
            }

            return "NO";
        }
        return "YES";
    }
}