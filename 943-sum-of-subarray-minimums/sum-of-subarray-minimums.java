class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = nextSmallerElement(arr);
        int[] pse = previousSmallerElement(arr);
        long total = 0; 
        int mod = (int) (1e9 + 7);

        for(int i = 0; i < arr.length; ++i)
        {
            int left = i - pse[i];
            int right = nse[i] - i;

            total += (long) left * right % mod * arr[i] % mod % mod;
            total %= mod;
        }
        return (int) total;

    }
    public int[] nextSmallerElement(int[] arr)
    {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack();

        for(int i = arr.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
            {
                stack.pop();
            }
            result[i] = (stack.isEmpty()) ? arr.length : stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int[] previousSmallerElement(int[] arr)
    {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < arr.length; i++)
        {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()])
            {
                stack.pop();
            }
            result[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }
}