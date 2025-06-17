class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int left = 0;
        int current = 0;
        int result = 0;
        
        for(int right = 0; right < s.length(); right++)
        {
            if(set.contains(s.charAt(right)))
            {
                current++;
            }

            if(right - left + 1 == k)
            {
                result = Math.max(result, current);
                if(set.contains(s.charAt(left)))
                {
                    current--;
                }
                left++;
            }
        }
        return result;
    }
}