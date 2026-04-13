class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[nums.length];
        int n = nums.length;

        for(int i = 2 * n - 1; i >= 0; i--)
        {
            int current = nums[i % n];

            while(!stack.isEmpty() && stack.peek() <= current) stack.pop();

            if(i < n) 
            {
                result[i] = (stack.isEmpty()) ? -1 : stack.peek();
            }
            stack.push(current);
        }
        return result;
    }
}