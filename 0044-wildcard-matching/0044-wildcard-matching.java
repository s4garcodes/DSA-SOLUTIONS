class Solution {
    public boolean isMatch(String text, String pattern) {
        int n=text.length();
        int m=pattern.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,m-1,text,pattern,dp)==1;
    }
    private int fun(int i,int j, String text, String pattern,int[][] dp){
        if(i<0 && j<0) return 1;
        if(j<0 && i>=0) return 0;
        if(i<0 && j>=0){
            for(int ii=0;ii<=j;ii++){
                if(pattern.charAt(ii)!='*') return 0;
                
            }
            return 1; 
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(text.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='?'){
            return dp[i][j]=fun(i-1,j-1,text,pattern,dp);
        }
        if(pattern.charAt(j)=='*'){
            return dp[i][j]=(fun(i - 1, j, text, pattern,dp) == 1 || fun(i, j - 1, text, pattern,dp) == 1) ? 1 : 0;
        }
        return 0;
    }
}