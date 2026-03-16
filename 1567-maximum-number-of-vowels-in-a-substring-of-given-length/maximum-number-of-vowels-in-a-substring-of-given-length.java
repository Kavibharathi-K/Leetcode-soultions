class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int left = 0;
        int right = 0;
        int currentCount = 0;
        int result = 0;

        while(right < s.length())
        {
            if(right - left + 1 < k)
            {
                if(set.contains(s.charAt(right))) currentCount++;
                right++;
                continue;
            }

            if(set.contains(s.charAt(right))) currentCount++;
            result = Math.max(result, currentCount);
            if(set.contains(s.charAt(left))) currentCount--;
            left++;
            right++;
        }
        return result;
    }
}