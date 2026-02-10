class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int result = -1;

        for(int i = 0; i < bloomDay.length; i++)
        {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }


        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            System.out.println("mid" + mid);
            if(canMake(bloomDay, mid, m, k))
            {
                System.out.println("Can Make");
                System.out.println("Right" + right);
                System.out.println("Left" + left);
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }

    public boolean canMake(int[] nums, int days, int bouquets, int k)
    {
        int count = 0;
        int run = k;

        for(int i = 0; i < nums.length; i++)
        {
            if(run == 0)
            {
                count++;
                run = k;
            }

            if(nums[i] <= days) run--;
            else run = k;
        }

        if(run == 0) count++;
        return count >= bouquets;
    }
}