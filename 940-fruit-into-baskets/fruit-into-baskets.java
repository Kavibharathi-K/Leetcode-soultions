class Solution {
    public int totalFruit(int[] nums) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;

        while(right < nums.length)
        {
            basket.put(nums[right], basket.getOrDefault(nums[right], 0) + 1);

            while(basket.size() > 2)
            {
                basket.put(nums[left], basket.get(nums[left]) - 1);
                basket.remove(nums[left], 0);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}