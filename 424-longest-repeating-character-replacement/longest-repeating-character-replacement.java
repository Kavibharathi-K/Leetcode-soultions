class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        int currentMax = 0;
        int[] freq = new int[26];

        while(right < s.length())
        {
            int fr = s.charAt(right) - 'A';
            freq[fr]++;
            currentMax = Math.max(currentMax, freq[fr]);

            while((right - left + 1) - currentMax > k)
            {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, (right - left + 1));
            right++;
        }
        return result;
    }
}