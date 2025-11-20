class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int right = 0;
        int currentRecovery = 0;
        int maxRecovery = 0;
        int alreadySatisfied = 0;

        for(int i = 0; i < customers.length; i++)
        {
            if(grumpy[i] == 0) alreadySatisfied += customers[i];
        }

        while(right < customers.length)
        {
            if(grumpy[right] == 1) currentRecovery += customers[right];

            if(right - left + 1 == minutes)
            {
                maxRecovery = Math.max(maxRecovery, currentRecovery);
                if(grumpy[left] == 1) currentRecovery -= customers[left];
                left++;
            }
            right++;
        }
        return alreadySatisfied + maxRecovery;
    }
}