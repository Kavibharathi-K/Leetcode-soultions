class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int currentArea = 0;

        int pointer1 = 0;
        int pointer2 = height.length - 1;

        while(pointer1 < pointer2)
        {
            int h = Math.min(height[pointer1], height[pointer2]);
            int w = pointer2 - pointer1;
            currentArea = h * w;
            max = Math.max(currentArea, max);

            while(pointer1 < pointer2 && height[pointer1] <= h) pointer1++;
            while(pointer1 < pointer2 && height[pointer2] <= h) pointer2--;
        }
        return max;
    }
}