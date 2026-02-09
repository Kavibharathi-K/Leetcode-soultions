class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        int result = 0;

        for(int i = 0; i < piles.length; i++) right = Math.max(right, piles[i]);

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(canEat(piles, h, mid))
            {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }

    public boolean canEat(int[] piles, int h, int bananaPerHour)
    {
        long currentHoursNeeded = 0;
        for(int i = 0; i < piles.length; i++)
        {
            currentHoursNeeded += (piles[i] + bananaPerHour - 1) / bananaPerHour;

        }

        return currentHoursNeeded <= h;
    }
}