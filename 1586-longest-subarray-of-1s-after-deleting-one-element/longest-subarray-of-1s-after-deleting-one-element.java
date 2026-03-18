class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeros = 0;
        int result = 0;

        while(right < nums.length)
        {
            if(nums[right] == 0) zeros++;

            while(zeros > 1 && left <= right)
            {
                if(nums[left] == 0) zeros--;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result - 1;
    }
}