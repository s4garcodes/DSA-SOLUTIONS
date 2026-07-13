class Solution {
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp =new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,m-1,s1,s2,dp);
    }
    private int fun(int i,int j,String s1,String s2,int[][] dp){
        if(i<0) return 1+j;
        if(j<0) return 1+i;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
           return dp[i][j]= fun(i-1,j-1,s1,s2,dp); 
        }
        else{
        int insert = 1 + fun(i,j-1,s1,s2,dp);
        int remove = 1 + fun(i-1,j,s1,s2,dp);
        int replace = 1 + fun(i-1,j-1,s1,s2,dp);
        return dp[i][j]= Math.min(insert,Math.min(remove,replace)); 
        }
    }
}