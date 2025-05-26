class Solution {
    public int countGoodSubstrings(String s) {
        int left = 0;
        int count = 0;

        for(int right = 2; right < s.length(); right++)
        {
            char c1 = s.charAt(left);
            char c2 = s.charAt(left + 1);
            char c3 = s.charAt(right);

            if(c1 != c2 && c2 != c3 && c1 != c3) count++;

            left++;
        }
        return count;
    }
}