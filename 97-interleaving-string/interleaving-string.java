class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        if(n + m != s3.length()) return false;

        dp[n][m] = true;

        for(int p1 = n; p1 >= 0; p1--)
        {
            for(int p2 = m; p2 >= 0; p2--)
            {
                if(p1 < n && s1.charAt(p1) == s3.charAt(p1 + p2) && dp[p1 + 1][p2]) dp[p1][p2] = true;
                if(p2 < m && s2.charAt(p2) == s3.charAt(p1 + p2) && dp[p1][p2 + 1]) dp[p1][p2] = true;
            }
        }
        return dp[0][0];
    }
}