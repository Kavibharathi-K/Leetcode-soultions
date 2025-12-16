class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int windowZeros = 0;
        int result = 0;

        for(right = 0; right < nums.length; right++)
        {
            if(nums[right] == 0) windowZeros++;

            while(windowZeros > k)
            {
                if(nums[left] == 0) windowZeros--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}