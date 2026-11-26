class Solution {
    void dfs(char[][]grid,int i,int j,int m,int n,boolean[][]vis){
        
      if(i<0||j<0||i>=n||j>=m||grid[i][j]=='0'|| vis[i][j]){
        return;
        }
        vis[i][j]=true;
        dfs(grid,i-1,j,m,n,vis);  //top
        dfs(grid,i,j+1,m,n,vis);  //right
        dfs(grid,i,j-1,m,n,vis);  //left
        dfs(grid,i+1,j,m,n,vis);   //down
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count=0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    count++;
                    dfs(grid,i,j,m,n,vis);
                }
            }
        }
        return count;
        
    }
}