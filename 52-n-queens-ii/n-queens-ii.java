class Solution {
    boolean isSafe(int row,int col,char[][] board,int n){
        int deeprow = row;
        int deepcol = col;
        while(row>=0&&col>=0){
            if(board[row][col]=='Q')
            return false;
            row--;
            col--;
        }
        row = deeprow;
        col = deepcol;
        while(col>=0){
            if(board[row][col]=='Q')
            return false;
            col--;
        }
        row = deeprow;
        col = deepcol;
        while(row<n&&col>=0){
            if(board[row][col]=='Q')
            return false;
            row++;
            col--;
        }
        return true;
    }
    List<List<String>> solve(int col,char[][] board,int n,List<List<String>>ans){
    if(col==n){
        List<String>current = new ArrayList<>();
        for(int i = 0;i<n;i++){
            current.add(new String (board[i]));
        }
    ans.add(current);
    return ans;
    }
    for(int row= 0;row<n;row++){
        if(isSafe(row,col,board,n)){
            board[row][col] = 'Q';
            solve(col+1,board,n,ans);
            board[row][col]='.';
        }
        }
        return ans;
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>>ans=new ArrayList<>();
        solve(0,board,n,ans);
        return ans.size();
        
    }
}