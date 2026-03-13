class Solution {
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int index2 = -1;

        for(int i = nums.length - 1; i >= 1; i--)
        {
            if(nums[i - 1] < nums[i])
            {
                index1 = i - 1;
                break;
            }
        }
        if(index1 == -1)
        {
            reverse(0, nums.length - 1, nums);
            return;
        }

        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(nums[i] > nums[index1]) 
            {
                index2 = i;
                break;
            }
        }

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        
        reverse(index1 + 1, nums.length - 1, nums);
    }

    public void reverse(int start, int end, int[] nums)
    {
        while(start <= end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; 
            end--;
        }
    }
}