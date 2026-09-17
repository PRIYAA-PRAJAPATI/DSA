class Solution {
    int[][] dp;
    int fun(int i ,int j,String s,String t){
        int n = s.length();
        int m = t.length();
        if(i>=n||j>=m)
        return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= 1+fun(i+1,j+1,s,t);
        }
        else{
            int c1 = fun(i+1,j,s,t);
            int c2 = fun(i,j+1,s,t);
           return dp[i][j]=Math.max(c1,c2);
        }
      
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(0,0,text1,text2);
        
    }

}