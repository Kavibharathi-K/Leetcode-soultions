class Solution {
    public void moveZeroes(int[] nums) {
        int next = 0;
        int pointer = 0;

        while(pointer < nums.length)
        {
            if(nums[pointer] != 0)
            {
                nums[next] = nums[pointer];
                next++;
            }
            pointer++;
        }
        while(next < nums.length) nums[next++] = 0;
    }
}