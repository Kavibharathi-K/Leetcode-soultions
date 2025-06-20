class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length()) return result;

    int[] targetFreq = new int[26];
    int[] windowFreq = new int[26];
    int matchCount = 0;

    // Build frequency map for pattern
    for (char c : p.toCharArray()) {
        targetFreq[c - 'a']++;
    }

    int left = 0, right = 0;
    int totalMatchesNeeded = 0;

    // Count how many distinct characters are in target
    for (int i = 0; i < 26; i++) {
        if (targetFreq[i] > 0) {
            totalMatchesNeeded++;
        }
    }

    while (right < s.length()) {
        int index = s.charAt(right) - 'a';
        windowFreq[index]++;

        // If frequency now matches, increment matchCount
        if (windowFreq[index] == targetFreq[index]) {
            matchCount++;
        }

        // If window size exceeds p.length(), remove from left
        if (right - left + 1 > p.length()) {
            int leftIndex = s.charAt(left) - 'a';

            // If frequency matched before removing, decrement matchCount
            if (windowFreq[leftIndex] == targetFreq[leftIndex]) {
                matchCount--;
            }

            windowFreq[leftIndex]--;
            left++;
        }

        // If all characters match in frequency, add start index
        if (matchCount == totalMatchesNeeded) {
            result.add(left);
        }

        right++;
    }

    return result;
}

}