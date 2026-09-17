class Solution {
    int[][] dp;
    int fun(int i,int j,String str){
     if(i>j){ 
        return 0;
        }
        if(i==j){ 
        return 1;
        }
        if(dp[i][j] !=-1)
        return dp[i][j];
        if(str.charAt(i)==str.charAt(j)){ 
            return dp[i][j]= 2+fun(i+1,j-1,str);
        }
        int c1=fun(i+1,j,str);
        int c2 = fun(i,j-1,str);
        return dp[i][j]=Math.max(c1,c2);
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }
        return fun(0,n-1,s);

        
    }
}