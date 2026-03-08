class Solution {
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int index2 = -1;

        for(int i = nums.length - 1; i >= 1; i--)
        {
            if(nums[i] > nums[i - 1])
            {
                index1 = i - 1;
                break;
            }
        }
        if(index1 == -1)
        {
            reverse(0, nums.length -1, nums);
        }
        else 
        {
            for(int i = nums.length - 1; i >= index1; i--)
            {
                if (nums[i] > nums[index1])
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
    }
    void reverse(int start, int end, int[] arr)
    {
        while(start <= end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
}