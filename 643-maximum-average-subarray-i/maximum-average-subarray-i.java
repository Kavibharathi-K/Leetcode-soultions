class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currentTotal = 0;
        double currentAverage = 0;
        double total = 0;

        for(int i = 0; i < k; i++)
        {
            total += nums[i];
        }

        double result = total/k;

        int left = 0;

        for (int right = 0; right < nums.length; right++)
        {
            currentTotal += nums[right];
            if(right - left + 1 != k) continue;

            currentAverage = currentTotal / k;
            result = Math.max(currentAverage, result);
            currentTotal -= nums[left];
            left++;
        }
        return result;
    }
}