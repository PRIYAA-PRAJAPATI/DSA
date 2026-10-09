class Solution {
    int [][] dp;
    int fun(int x,int y,int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        if(x<0||x>=n||y<0||y>=m)return Integer.MAX_VALUE;

        if(x==n-1)return grid[x][y];
        if(dp[x][y]!=Integer.MIN_VALUE) return dp[x][y];
        int down = fun(x+1,y,grid);
        int left = fun(x+1,y-1,grid);
        int right = fun(x+1,y+1,grid);
         int min = Math.min(down, Math.min(left, right));

      dp[x][y] = grid[x][y] + Math.min(down, Math.min(left, right));
       return dp[x][y];
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       dp = new int[n][m];
        int ans = Integer.MAX_VALUE;
      
       for(int e[]:dp){
        Arrays.fill(e,Integer.MIN_VALUE);
       }
       

       for(int i = 0;i<m;i++){
        ans = Math.min(ans,fun(0,i,grid));
    
       }
       return ans;
    }
}