class Solution {
    public int maximumCount(int[] nums) {
        int lastNeg = getLastNeg(nums);
        int firstPos = getFirstPos(nums);

        int negCount = (lastNeg == -1) ? 0 : lastNeg + 1;
        int posCount = (firstPos == nums.length) ? 0 : nums.length - firstPos;
        return Math.max(negCount, posCount);
    }   

    public int getLastNeg(int[] nums)
    {
        if(nums[0] >= 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] >= 0) right = mid - 1;
            else left = mid;
        }
        return left;
    }

    public int getFirstPos(int[] nums)
    {
        if(nums[nums.length - 1] <= 0) return nums.length;
        int left = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= 0) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}