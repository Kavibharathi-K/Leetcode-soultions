class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalPts = 0;
        int left = 0;
        int right = 0;
        int currentPts = 0;
        int result = 0;

        for(int i = 0; i < cardPoints.length; i++)
        {
            totalPts += cardPoints[i];
        }

        if(k == n) return totalPts;
        
        while(right < cardPoints.length)
        {
            if(right - left + 1 < n - k)
            {
                currentPts += cardPoints[right];
                right++;
                continue;
            }
            currentPts += cardPoints[right];
            result = Math.max(result, totalPts - currentPts);
            currentPts -= cardPoints[left++];
            right++;
        }
        return result;
    }
}