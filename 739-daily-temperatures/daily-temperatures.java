class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] result = new int[temp.length];
        Stack<Integer> stack = new Stack();

        for(int i = temp.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && temp[stack.peek()] <= temp[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                result[i] = 0;
                stack.push(i);
                continue;
            }
            result[i] = stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}