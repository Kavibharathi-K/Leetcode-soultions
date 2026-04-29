class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int currentArea = 0;

        while(left < right)
        {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            currentArea = h * w;
            result = Math.max(result, currentArea);

            while(left < right && height[left] <= h) left++;
            while(left < right && height[right] <= h) right--;
        }
        return result;
    }
}