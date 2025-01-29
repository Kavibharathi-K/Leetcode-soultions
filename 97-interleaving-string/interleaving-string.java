class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return backtrack(0, 0, 0, s1, s2, s3, dp);
    }

    boolean backtrack(int point1, int point2, int point3, String s1, String s2, String s3, Boolean[][] dp)
    {
        if(point3 == s3.length())
        {
            return (point1 == s1.length() && point2 == s2.length());
        }
        if(dp[point1][point2] != null) return dp[point1][point2];

        boolean result = false;
        if(point1 < s1.length() && s1.charAt(point1) == s3.charAt(point3))
        {
            result = backtrack(point1 + 1, point2, point3 + 1, s1, s2, s3, dp);
        }

            if(!result && point2 < s2.length() && s2.charAt(point2) == s3.charAt(point3)) 
        {
            result = backtrack(point1, point2 + 1, point3 + 1, s1, s2, s3, dp);
        }

        dp[point1][point2] = result;
        return result;
    }
}