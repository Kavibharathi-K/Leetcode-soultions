class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int frequency = 1;

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != candidate) frequency--;
            else frequency++;

            if(frequency == 0) 
            {
                candidate = nums[i];
                frequency = 1;
            }
        }
        return candidate;
    }
}