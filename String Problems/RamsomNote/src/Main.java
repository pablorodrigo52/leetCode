import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final var magazine = List.of("give me one grand today night".split(" "));
        final var note = List.of("give one grand today".split(" "));
        checkMagazine(magazine, note);
    }

    public static void checkMagazine(List<String> magazine, List<String> note) { // time complexity: O(n), space complexity: O(n)
        // need to verify if al note words exists on magazine words (size too)
        // can be with space complexity O(1) ?

        Map<String, Integer> magazineFrequency = frequencyWords(magazine);

        for (var key : note) {
            Integer times = magazineFrequency.get(key);
            if (times == null || times == 0) {
                System.out.println("No");
                return;
            }

            if (times > 0) {
                magazineFrequency.put(key, times - 1);
            }
        }

        System.out.println("Yes");
    }

    private static Map<String, Integer> frequencyWords(List<String> source ) {
        final Map<String, Integer> frequency = new HashMap<>();

        for(String word : source) {
            if (frequency.get(word) == null){
                frequency.put(word, 1);
            } else {
                int freq = frequency.get(word);
                frequency.put(word,  freq + 1);
            }
        }

        return frequency;
    }
}