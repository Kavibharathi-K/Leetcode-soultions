class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] % 2 == 0)
            {
                result[left++] = nums[i];
            }
            else result[right--] = nums[i];
        }
        return result;
    }
}