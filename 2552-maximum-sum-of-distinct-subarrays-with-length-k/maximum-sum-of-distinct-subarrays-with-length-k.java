class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        int left = 0;
        int right = 0;
        long currentSum = 0;

        while(right < nums.length)
        {
            if(right - left + 1 < k)
            {
                freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
                currentSum += nums[right];
                right++;
                continue;
            }

            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            currentSum += nums[right];

            if(freq.size() == k) result = Math.max(result, currentSum);

            freq.put(nums[left], freq.get(nums[left]) - 1);
            if(freq.get(nums[left]) == 0) freq.remove(nums[left]);

            currentSum -= nums[left];
            left++;
            right++;
        }
        return result;
    }
}