class Solution {
    public int bestClosingTime(String customers) {
        int serviceHours = 0;
        for (char c: customers.toCharArray()) { //O(n)
            if (c == 'Y') {
                serviceHours++;
            }
        }

        int earliestHour = 0;
        int minimalPenalty = 9999999;
        int penaltyFactor = 0;

        for(int j = 0; j <= customers.length(); j++) { // O(n)
            int calculatedPenalty = serviceHours - penaltyFactor;

            if (minimalPenalty > calculatedPenalty) {
                earliestHour = j;
                minimalPenalty = calculatedPenalty;
            }

            if (j < customers.length() && customers.charAt(j) == 'Y') {
                penaltyFactor++;
            } else {
                penaltyFactor--;
            }
        }

        return earliestHour;
    }
}
