class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        int ans = 0;

        for(int i = 0; i < piles.length; i++)
        {
            if(piles[i] > right) right = piles[i];
        }

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(canEat(piles, h, mid))
            {
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return ans;
    }

    public boolean canEat(int[] piles, int h, int k)
    {
        long currentHoursNeeded = 0;
        for(int i = 0; i < piles.length; i++)
        {
            currentHoursNeeded += (piles[i] + k - 1) / k;

        }

        return currentHoursNeeded <= h;
    }
}