class Solution {
    int[][] dp = new int[501][501];
     int fun(int i, int p, int max, int[] arr, int k) {
    if(i>=arr.length)return 0;
    int len = i-p+1;
    if(dp[i][p]!= -1) return dp[i][p];
    max = Math.max(max,arr[i]);
    int ans = 0;
    
    
    if(len==k){
        int a = max*len+ fun(i+1,i+1,0,arr,k);
        ans = a;
    }else{
         int a = max*len+ fun(i+1,i+1,0,arr,k);
         int b = fun(i+1,p,max,arr,k);
         ans= Math.max(ans,a);
         ans=Math.max(ans,b);
    }
    return dp[i][p]=ans;
    }



    public int maxSumAfterPartitioning(int[] arr, int k) {
     for(int i = 0;i<501;i++){
        Arrays.fill(dp[i],-1);
}
        return fun(0,0,0,arr,k);
        
    }
}