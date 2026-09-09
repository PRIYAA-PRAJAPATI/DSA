class Solution {
    int[] dp;
    public int tribonacci(int n) {
        dp = new int [n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    int solve(int n){
      if(n==0)
      return 0;
      if(n==1 || n==2)
      return 1;
     
      if(dp[n] != -1) return dp[n];
       int curr=solve(n-1)+solve(n-2)+solve(n-3);
       return dp[n] = curr;
    }
}