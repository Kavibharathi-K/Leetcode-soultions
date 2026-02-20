class Solution {
    public int removeElement(int[] nums, int val) {
        int next = 0;
        int pointer = 0;

        while(pointer < nums.length)
        {
            if(nums[pointer] != val)
            {
                nums[next] = nums[pointer];
                next++;
            }
            pointer++;
        }
        return next;
    }
}