class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet();
        int left = 0;
        int right = 0;
        int result = 0;

        while(right < s.length())
        {
            if(window.contains(s.charAt(right)))
            {
                window.remove(s.charAt(left++));
            }
            else
            {
                window.add(s.charAt(right++));
                result = Math.max(result, window.size());
            }
        }
        return result;
    }
}