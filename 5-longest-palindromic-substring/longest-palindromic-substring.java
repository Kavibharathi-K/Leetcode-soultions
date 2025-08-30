class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;

        String result = "";
        for(int i = 1; i < s.length(); i++)
        {
            int left = i;
            int right = i;

            while(s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;

                if(left == -1 || right == s.length()) break;
            }

            String pal = s.substring(left + 1, right);
            if(pal.length() > result.length()) result = pal;

            left = i - 1;
            right = i;

            while(s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
                
                if(left == -1 || right == s.length()) break;
            }

            pal = s.substring(left + 1, right);
            if(pal.length() > result.length()) result = pal;
        }
        return result;
    }
}