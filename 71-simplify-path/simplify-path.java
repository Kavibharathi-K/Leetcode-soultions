class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack();

        for(String s : arr)
        {
            if(s.equals(".."))
            {
                if(!stack.isEmpty()) stack.pop();
            }
            else if(!s.equals(".") && !s.equals("")) stack.push(s);
        }
        StringBuilder result = new StringBuilder();
        for(String s : stack) result.append("/").append(s);

        return (result.length() == 0) ? "/" : result.toString();
    }
}