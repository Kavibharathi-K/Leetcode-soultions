class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer1 = 0;
        int pointer2 = 1;

        while(pointer2 < nums.length)
        {
            if(nums[pointer1] != nums[pointer2])
            {
                nums[++pointer1] = nums[pointer2];
            }
            pointer2++;
        }
        return pointer1 + 1;
    }
}