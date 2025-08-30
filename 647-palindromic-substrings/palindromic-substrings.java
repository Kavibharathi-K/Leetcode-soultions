class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;

        int count = 0;

        for(int i = 1; i < s.length(); i++)
        {
            int left = i;
            int right = i;

            while(s.charAt(left) == s.charAt(right))
            {
                count++;
                left--;
                right++;

                if(left == -1 || right == s.length()) break;
            }

            left = i - 1;
            right = i;
            
            while(s.charAt(left) == s.charAt(right))
            {
                count++;
                left--;
                right++;

                if(left == -1 || right == s.length()) break;
            }
        }
        return count + 1;
    }
}