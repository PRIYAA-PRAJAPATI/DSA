class Solution {
    int[][] dp;
    int fun(int i,int j,int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        if(i>=n||j>=m){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1)
        return dp[i][j];
        if(i == n-1 && j == m-1) return grid[i][j];
        
        int c1 = fun(i,j+1,grid); //right
        int c2 = fun(i+1,j,grid); //down
       dp[i][j] = grid[i][j] +  Math.min(c1,c2);
       return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
       
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0,0,grid);
        
    }
}