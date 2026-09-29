class Solution {
    int[][] dp;
    int fun(int i ,int j,int m,int n,int[][] grid){
        if(i>=m || j>=n)        //out of bound
    return 0;
    if(grid[i][j] == 1){     //this is obstacle
     return 0;
     }
    if(i==m-1 && j==n-1)    //destination 
    return 1;
    if(dp[i][j] != -1){    //already calculated
        return dp[i][j];
    }
    
    int a = fun(i+1,j,m,n,grid);
    int b = fun(i,j+1,m,n,grid);
    dp[i][j] = a+b;
    return dp[i][j];
}
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
       dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return fun(0,0,m,n,obstacleGrid); 
    }
}