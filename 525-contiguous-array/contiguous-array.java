class Solution {
    public int findMaxLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int max = 0;
        int diff = 0;

        for(int i = 0; i < nums.length; i++)
        {
            diff += (nums[i] == 0) ? -1 : 1;
            if(diff == 0) max = i + 1;

            if(!map.containsKey(diff)) map.put(diff, i);
            else max = Math.max(max, i - map.get(diff));
        }
        return max;
    }

} 