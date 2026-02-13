class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        int result = 0;

        for(int i = 0; i < nums.length; i++)
        {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(canSplit(nums, mid, k))
            {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }

    public boolean canSplit(int[] nums, int maxSum, int k)
    {
        int count = 1;
        int currentSum = 0;

        for(int num : nums)
        {
            if(currentSum + num > maxSum)
            {
                currentSum = num;
                count++;
            }
            else currentSum += num;
        }
        return count <= k;
    }
}