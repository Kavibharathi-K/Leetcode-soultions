class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++)
        {
            if(stack.size() == 0) stack.push(s.charAt(i));
            else if(stack.peek() == s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
        }

        StringBuilder str = new StringBuilder();
        while(stack.size() > 0) 
        {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}