class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int[] num : dp) Arrays.fill(num, - 1);

        for(int i = 0; i <= text1.length(); i++) dp[i][0] = 0;
        for(int i = 0; i <= text2.length(); i++) dp[0][i] = 0;

        for(int index1 = 1; index1 <= text1.length(); index1++)
        {
            for(int index2 = 1; index2 <= text2.length(); index2++)
            {
                if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) 
                {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                }
                else
                {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];

        // return backtrack(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    int backtrack(String text1, String text2, int index1, int index2, int[][] dp)
    {
        if(index1 < 0 || index2 < 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(text1.charAt(index1) == text2.charAt(index2)) return dp[index1][index2] = 1 + backtrack(text1, text2, index1 - 1, index2 - 1, dp);
        return dp[index1][index2] = Math.max(backtrack(text1, text2, index1 - 1, index2, dp), backtrack(text1, text2, index1, index2 - 1, dp));
    }
}
