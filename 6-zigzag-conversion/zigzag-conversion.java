class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] result = new StringBuilder[numRows];
        int index = 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i < numRows; i++) result[i] = new StringBuilder();

        while(index < ch.length)
        {
            for(int i = 0; i < numRows && index < ch.length; i++)
            {
                result[i].append(ch[index++]);
            }

            for(int i = numRows - 2; i > 0 && index < ch.length; i--)
            {
                result[i].append(ch[index++]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }
}