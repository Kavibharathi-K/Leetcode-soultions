class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        int result = 0;
        for(int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(canShip(weights, mid, days))
            {
                result= mid;
                right = mid - 1;
            }
            else left = mid + 1;
        } 
        return result;
    }

    public boolean canShip(int[] weights, int capacity, int days)
    {
        int count = 1;
        int current = 0;
        for(int i = 0; i < weights.length; i++)
        {
            if(current + weights[i] > capacity)
            {
                count++;
                current = weights[i];
            }
            else current += weights[i];
        }
        return count <= days;
    }
}