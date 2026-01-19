class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = searchForFirst(nums, target);
        ans[1] = searchForLast(nums, target);
       return ans;
    }

    public int searchForFirst(int[] nums, int target)
    {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
            {
                index = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target)
            {
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return index;
    }
     public int searchForLast(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int index = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                index = mid;
                left = mid + 1;
            }
            else if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return index;
    }
}