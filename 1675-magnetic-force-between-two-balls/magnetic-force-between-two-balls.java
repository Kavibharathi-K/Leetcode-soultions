class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1; 
        int right = position[position.length - 1];
        int result = 0;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(canPlace(position, mid, m))
            {
                result = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return result;
    }

    public boolean canPlace(int[] nums, int distance, int m)
    {
        int count = 1;
        int lastPosition = nums[0];

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] - lastPosition >= distance)
            {
                lastPosition = nums[i];
                count++;
            }
        }

        return count >= m;
    }
}