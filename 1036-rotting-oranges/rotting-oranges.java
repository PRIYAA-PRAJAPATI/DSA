class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
       int n = grid[0].length;
        int freshcount = 0 ;
        int currRot = 0 ;
        Queue<int[]> q= new LinkedList<>();   
        for(int i = 0;i<m;i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j]==2 )    {
                    q.offer(new int[]{i,j});
                }     
                else if( grid[i][j]==1){
                    freshcount++;
                }  
            }
        }
        int min = 0 ;
      while(!q.isEmpty() && freshcount>0){
        currRot = q.size();
        while(currRot > 0 ){
            int[] node = q.poll();
          int r = node[0];
          int c = node[1];
          if (r - 1 >= 0 && grid[r - 1][c] == 1) {
            grid[r - 1][c] = 2;
            freshcount--;
            q.offer(new int[]{r - 1, c});  
        
        }

        if (r + 1 < m &&grid[r + 1][c] == 1) {
            grid[r + 1][c] = 2;
            freshcount--;
            q.offer(new int[]{r + 1, c});
         
        }

        if (c - 1 >= 0 &&   grid[r][c - 1] == 1) {
            grid[r][c - 1] = 2;
            freshcount--;
            q.offer(new int[]{r, c - 1});
            
        }

        if (c + 1 < n && grid[r][c + 1] == 1) {
            grid[r][c + 1] = 2;
            freshcount--;
            q.offer(new int[]{r, c + 1});
            
            
        }
        currRot--;
    }
min++;
  
}

if (freshcount == 0) {
    return min;
} 
else {
    return -1;
}
    }
}