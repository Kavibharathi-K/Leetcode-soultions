class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int currentCount = 0;
        int result = 0;
        String vowels = "aeiou";

        while(right < s.length())
        {
            if(vowels.indexOf(s.charAt(right)) != -1) currentCount++;

            if(right - left + 1 == k)
            {
                result = Math.max(result, currentCount);
                if(vowels.indexOf(s.charAt(left)) != -1) currentCount--;
                left++;
                right++;
            }
            else 
            {
                right++;
                continue;
            }
        }
        return result;
    }
}
// left = a right = c
// left = b right = i
// left = c right = i
// left = i right = i
// left = i right = d
// left = i right = e
// left = d right = f