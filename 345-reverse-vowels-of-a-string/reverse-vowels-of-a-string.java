class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');

        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && !list.contains(chars[left])){
                left++;
            }
            while(left < right && !list.contains(chars[right])){
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }
}