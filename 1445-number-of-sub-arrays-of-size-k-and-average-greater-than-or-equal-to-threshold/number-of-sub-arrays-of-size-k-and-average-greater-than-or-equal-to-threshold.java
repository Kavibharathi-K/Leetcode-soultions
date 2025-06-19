class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int current = 0;
        int result = 0;

        for(int right = 0; right < arr.length; right++)
        {
            current += arr[right];

            if(right - left + 1 == k)
            {
                if(current / k >= threshold) result++;
                current -= arr[left];
                left++;
            }
        }
        return result;
    }
}