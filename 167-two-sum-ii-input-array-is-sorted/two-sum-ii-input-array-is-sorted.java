class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;

        while(p1 < numbers.length && p2 >= 0)
        {
            if(numbers[p1] + numbers[p2] == target)
            {
                return new int[]{p1 + 1, p2 + 1};
            }
            else if(numbers[p1] + numbers[p2] > target) p2--;
            else p1++;
        }
        return new int[]{0,0};
    }
}