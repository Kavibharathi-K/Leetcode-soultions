class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int right = 0;
        int currentTotal = 0;
        int result = 0;

        while(right < arr.length)
        {
            currentTotal += arr[right];

            if((right - left + 1) == k)
            {
                if(currentTotal / k >= threshold)
                {
                    result++;
                }

                currentTotal -= arr[left];
                left++;
            }
            right++;
        }
        return result;
    }
}