class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int leftMax = height[left];
        int rightMax = height[right];

        while(left < right){
            if(leftMax < rightMax){
                result += leftMax - height[left++];
                leftMax = Math.max(leftMax, height[left]);
            }
            else{
                result += rightMax - height[right--];
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return result;
    }
}