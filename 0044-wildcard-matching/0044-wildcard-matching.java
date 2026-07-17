class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(n - 1, m - 1, s, p, dp) == 1;
    }

    private int fun(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0)
            return 1;
        if (j < 0 && i >= 0)
            return 0;
        if (i < 0 && j >= 0) {
            for (int ii = 0; ii <= j; ii++) {
                if (p.charAt(ii) != '*')
                    return 0;
            }
            return 1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = fun(i - 1, j - 1, s, p, dp);
        }
        if (p.charAt(j) == '*') {
            return dp[i][j] = (fun(i, j - 1, s, p, dp) == 1 || fun(i - 1, j, s, p, dp) == 1) ? 1 : 0;
        }
        return 0;
    }
}