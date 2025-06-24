class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);

            if (!need.containsKey(c)) {
                right++;
                left = right;
                have.clear();
                continue;
            }

            have.put(c, have.getOrDefault(c, 0) + 1);

            while (have.get(c) > need.get(c)) {
                char leftChar = s2.charAt(left);
                have.put(leftChar, have.get(leftChar) - 1);
                left++;
            }

            if ((right - left + 1) == s1.length()) return true;

            right++;
        }

        return false;
    }
}
