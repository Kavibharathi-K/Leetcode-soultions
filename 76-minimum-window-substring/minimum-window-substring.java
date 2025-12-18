class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        Map<Character, Integer> map = new HashMap();
        int count = 0;

        for(int i = 0; i < t.length(); i++)
        {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while(right < s.length())
        {

            char current = s.charAt(right);
            if(map.getOrDefault(current, 0) > 0) count++;

            map.put(current, map.getOrDefault(current, 0) - 1);

            while(count == t.length())
            {
                current = s.charAt(left);

                map.put(current, map.get(current) + 1);
                if(map.get(current) > 0) count--;
                
                if(right - left + 1 < minLen)
                {
                    minLen = right - left + 1;
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