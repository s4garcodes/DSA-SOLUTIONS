import java.util.Arrays;

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        // DP table needs size n x m
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        // BUG FIX: Pass 0-based maximum indices (n-1, m-1)
        return fun(n - 1, m - 1, s, t, dp);
    }
    
    public int fun(int i, int j, String s, String t, int[][] dp) {
        // BUG FIX: Check j < 0 first. If the target is fully matched, we found 1 valid subsequence.
        if (j < 0) return 1;
        if (i < 0) return 0;

        // MEMOIZATION: Return already calculated results
        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            // Option 1: Match these characters + Option 2: Skip this character in 's'
            dp[i][j] = fun(i - 1, j - 1, s, t, dp) + fun(i - 1, j, s, t, dp);
        } else {
            // Must skip this character in 's'
            dp[i][j] = fun(i - 1, j, s, t, dp);
        }
        
        return dp[i][j];
    }
}