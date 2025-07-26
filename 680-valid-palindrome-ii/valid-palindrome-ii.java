class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else 
            {
                return (isPal(start + 1, end, s) || isPal(start, end - 1, s));
            }
        }
        return true;
    }
    boolean isPal(int start, int end, String s)
    {
        while(start < end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
}