class Solution {
    public int evalRPN(String[] tokens) {
        int operand1 = 0;
        int operand2 = 0;
        Stack<Integer> stack = new Stack();

        for(String s : tokens)
        {
            if(s.equals("+"))
            {
                stack.push(stack.pop() + stack.pop());
            }
            else if(s.equals("-"))
            {
                operand2 = stack.pop();
                operand1 = stack.pop();
                stack.push(operand1 - operand2);
            }
            else if(s.equals("*"))
            {
                stack.push(stack.pop() * stack.pop());
            }
            else if(s.equals("/"))
            {
                operand2 = stack.pop();
                operand1 = stack.pop();
                stack.push(operand1 / operand2);
            }
            else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}