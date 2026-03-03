class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while(left <= right)
        {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            result = Math.max(result, area);

            while(left <= right && height[left] <= h) left++;
            while(left <= right && height[right] <= h) right--;
        }
        return result;
    }
}