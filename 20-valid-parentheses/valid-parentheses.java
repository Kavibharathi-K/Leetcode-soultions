class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);

            if(current == '(' || current == '[' || current == '{') stack.push(current);
            else
            {
                if(stack.size() == 0) return false;
                char peek = stack.peek();
                if((peek == '(' && current == ')') || (peek == '[' && current == ']') || (peek == '{' && current == '}'))
                {
                    stack.pop();
                    continue;
                }
                else return false;
            }
        }
        if (stack.size() == 0) return true;
        return false;
    }
}