class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int result = 0;
        int currentProduct = 1;

        for(int right = 0; right < nums.length; right++)
        {
            currentProduct *= nums[right];
            
            while(currentProduct >= k && left <= right)
            {
                currentProduct /= nums[left];
                left++;
            }
            result += (right - left + 1);
        }
        return result;
    }
}