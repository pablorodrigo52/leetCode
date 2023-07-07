import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        // verify if endWord exists in dictionary
        // how identify that a word differs only one letter

        System.out.println(BFSladderLength("hit", "cog", List.of ("hot", "dot", "dog", "lot", "log")));

        System.out.println(BFSladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));

        System.out.println(BFSladderLength("a", "c", List.of("a","b","c")));
            
    }

    private static int BFSladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> toVisit = new LinkedList<String>(); // needs to be a fifo structure
        Set<String> visited = new HashSet<String>();

        toVisit.add(beginWord);
        visited.add(endWord);

        int changes = 1;

        while (!toVisit.isEmpty()) {

            for (int i = 0; i < toVisit.size(); i++) { // for each word on my queue 
                String actualWord = toVisit.poll();

                if (actualWord.equals(endWord)) {
                    return changes;
                }

                for (int j = 0; j < actualWord.length(); j++) { // for each letter on my word, replace by another letter from alphabet                    
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        char [] splitedWord = actualWord.toCharArray();
                        splitedWord[j] = letter;

                        String newWord = new String(splitedWord);
                        if (wordList.contains(newWord) && !visited.contains(newWord) ) {
                            toVisit.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            changes++;
        }
        return changes;
    }


}