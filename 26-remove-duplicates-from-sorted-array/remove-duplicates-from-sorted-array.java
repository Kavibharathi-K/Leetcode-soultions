class Solution {
    public int removeDuplicates(int[] nums) {
        int storePointer = 1;
        int pointer = 1;

        while(pointer < nums.length)
        {
            if(nums[pointer] != nums[pointer - 1])
            {
                nums[storePointer++] = nums[pointer];
            }
            pointer++;
        }
        return storePointer--;
    }
}