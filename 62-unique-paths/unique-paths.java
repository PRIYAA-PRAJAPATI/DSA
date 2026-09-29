class Solution {
    int[][] dp;
    int fun(int i ,int j,int m,int n){
    if(i==m-1 && j==n-1)
    return 1;
    if(i>=m || j>=n)
    return 0;
    if(dp[i][j] != -1){
        return dp[i][j];
    }
    
    int a = fun(i+1,j,m,n);
    int b = fun(i,j+1,m,n);
    dp[i][j] = a+b;
    return dp[i][j];
}

    public int uniquePaths(int m,int n ) {
        dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return fun(0,0,m,n);
        
    }
}