class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        Map<Character, Integer> map = new HashMap();

        for(int i = 0; i < t.length(); i++)
        {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }


        while(right < s.length())
        {
            char ch = s.charAt(right);
            if(map.getOrDefault(ch, 0) > 0) count++;
            
            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while(count == t.length())
            {
                ch = s.charAt(left);
                map.put(ch, map.get(ch) + 1);
                if(map.get(ch) > 0) count--;

                if(right - left + 1 < minLen)
                {
                    minLen = (right - left + 1);
                    startIndex = left;
                }
                left++;
            }
            right++;
        }

        if(startIndex == -1) return "";
        return s.substring(startIndex, startIndex + minLen);
    }
}