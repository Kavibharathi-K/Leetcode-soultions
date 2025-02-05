class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                if(row == 0 && col == 0)
                {
                    dp[row][col] = grid[0][0];
                    continue;
                }

                int up = (int) Math.pow(10, 9);
                int left = (int) Math.pow(10, 9);

                if(row > 0) up = grid[row][col] + dp[row - 1][col];
                if(col > 0) left = grid[row][col] + dp[row][col - 1];

                dp[row][col] = Math.min(up, left);
            }
        }
        return dp[m - 1][n - 1];
    }

    int backtrack(int row, int col, int[][] grid)
    {
        if(row == 0 && col == 0) return grid[0][0];
        if(row < 0 || col < 0 ) return (int) Math.pow(10, 9);

        int up = grid[row][col] + backtrack(row - 1, col, grid);
        int left = grid[row][col] + backtrack(row, col - 1, grid);

        return Math.min(up, left);
    }
}