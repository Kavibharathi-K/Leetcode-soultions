class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left < right)
        {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            max = Math.max(max, h * w);

            while(left < right && height[left] <= h) left++;
            while(left < right && height[right] <= h) right--;
        }
        return max;
    }
}