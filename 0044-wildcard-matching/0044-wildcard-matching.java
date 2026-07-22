class Solution {
    public boolean isMatch(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,m-1,s,t,dp)==1;
    }
    private int fun(int i,int j,String s,String t,int[][]dp){
        if(i<0 && j<0) return 1;
        if(j<0 && i>=0)return 0;
        if(i<0 && j>=0){
            for(int ind=0;ind<=j;ind++){
                if(t.charAt(ind)!='*') return 0; 
            }
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j) || t.charAt(j)=='?'){
            return dp[i][j]=fun(i-1,j-1,s,t,dp);
        }
        if(t.charAt(j)=='*'){
            return dp[i][j]=(fun(i-1,j,s,t,dp)==1 || fun(i,j-1,s,t,dp)==1)? 1:0;
        }
        return 0;
    }
}