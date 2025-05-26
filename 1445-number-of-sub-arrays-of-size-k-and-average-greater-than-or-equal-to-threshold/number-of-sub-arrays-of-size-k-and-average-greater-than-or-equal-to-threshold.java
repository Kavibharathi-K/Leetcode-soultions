class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int count = 0;
        int currentTotal = 0;
        int currentAvg = 0;

        for(int right = 0; right < arr.length; right++)
        {
            currentTotal += arr[right];
            currentAvg = currentTotal / k;

            if(right >= k - 1)
            {
                currentTotal -= arr[left];
                left++;

                if (currentAvg >= threshold) count++;
            }
        }
        return count;
    }
}