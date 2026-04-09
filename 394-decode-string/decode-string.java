class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
       
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder str = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    str.insert(0, stack.pop());
                }
                stack.pop(); 
               
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }
                int repeatCount = Integer.parseInt(k.toString());
               
                String repeatedStr = str.toString().repeat(repeatCount);
                stack.push(repeatedStr);
            } else {
                stack.push(Character.toString(c));
            }
        }
       
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }}