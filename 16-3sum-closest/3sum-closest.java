class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right)
            {
                int currentSum = nums[i] + nums[left] + nums[right];
                if(currentSum == target) return target;
                else if(currentSum > target) right--;
                else left++;

                int currentDiff = Math.abs(currentSum - target);
                if(currentDiff < minDiff) 
                {
                    minDiff = currentDiff;
                    result = currentSum;
                }

            }
        }
        return result;
    }
}