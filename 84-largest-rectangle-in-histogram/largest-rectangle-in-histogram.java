class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nse = nse(heights);
        int[] pse = pse(heights);
        int ans = heights[0];

        for(int i = 0; i < heights.length; i++)
        {
            ans = Math.max(ans, ((nse[i] - pse[i] - 1)  * heights[i]));
        }
        return ans;
    }

    public int[] nse(int[] arr)
    {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack();

        for(int i = arr.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && arr[stack.peek()] >=  arr[i])
            {
                stack.pop();
            }
            result[i] = (stack.isEmpty()) ? arr.length : stack.peek();
            stack.push(i);
        }
        return result;
    }

    public int[] pse(int[] arr)
    {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < arr.length; i++)
        {
            while(!stack.isEmpty() && arr[stack.peek()] >  arr[i])
            {
                stack.pop();
            }
            result[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }
}