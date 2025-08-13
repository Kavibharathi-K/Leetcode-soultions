class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while(left < right)
        {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int currentArea = h * w;
            result = Math.max(currentArea, result);

            while(height[left] <= h & left < right) left++;
            while(height[right] <= h & left < right) right--;
        }
        return result;
    }
}