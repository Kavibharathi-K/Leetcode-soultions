class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap();
        int result = 0;
        map.put('a', -1);
        map.put('b', -1);
        map.put('c', -1);

        for(int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);
            map.put(current, i);
            if(map.values().stream().allMatch(v -> v > -1)) //if the window contains all three
            {
                int minValue = map.values().stream().min(Integer::compareTo).orElse(0);//get the start point of the minimum window that contains all three
                result += minValue + 1;
            }
        }
        return result;
    }
}