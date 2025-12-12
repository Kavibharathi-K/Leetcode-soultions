class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> basket = new HashMap();
        int left = 0;
        int right = 0;
        int result = 0;

        while(right < fruits.length)
        {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            while(basket.size() > 2)
            {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if(basket.get(fruits[left]) == 0) basket.remove(fruits[left]);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}