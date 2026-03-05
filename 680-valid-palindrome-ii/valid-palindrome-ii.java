class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int count = 0;

        while(left <= right)
        {
            if(count > 1) return false;
            if(s.charAt(left) == s.charAt(right))
            {
                left++;
                right--;
            }
            else
            {
               boolean possible1 = isPalindrome(left, right - 1, s);
               boolean possible2 = isPalindrome(left + 1, right, s);
               return possible1 || possible2;
            }
        }
        return true;
    }

    boolean isPalindrome(int start, int end, String s)
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