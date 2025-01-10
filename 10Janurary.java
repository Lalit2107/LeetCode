class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = getCharFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Step 2: Filter words1 to find universal strings
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = getCharFrequency(word);
            if (isSubset(freq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper method to calculate character frequency
    private int[] getCharFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Helper method to check if one frequency array satisfies another
    private boolean isSubset(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] < freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
