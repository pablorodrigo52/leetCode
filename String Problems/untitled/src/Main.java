public class Main {
    public static void main(String[] args) {

        String name = "HelloWorld!";
        printAllSubstrings(name);
    }

//    private static void printAllSubSequence(String s) {
//        System.out.println(s);
//        if (s.length() == 0) {
//            return;
//        }
//
//
//
//        String subs = s.substring(1);
//        printAllSubSequence(subs);
//    }

    private static void printAllSubstrings(String s) { // O(n^2)
        for (int i = 0; i < s.length(); i++) {
            StringBuilder subs = new StringBuilder();
            for(int j = i; j < s.length(); j++) {
                subs.append(s.charAt(j));
                System.out.print(subs + "\n");
            }
        }
    }
}