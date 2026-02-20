class Solution {
    public int removeDuplicates(int[] nums) {
        int next = 1;
        int pointer = 1;

        while(pointer < nums.length)
        {
            if(nums[pointer] != nums[pointer - 1])
            {
                nums[next] = nums[pointer];
                next++;
            }
            pointer++;
        }
        return next;
    }
}