class Solution {
    public int jump(int[] nums) {
       int n= nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i = n-2;i>=0;i--){
            int ans = Integer.MAX_VALUE;
            for(int j =1;j<=nums[i];j++){
                if(i + j < n){
               int m  = dp[i+j];
               if(m != Integer.MAX_VALUE){
                ans = Math.min(ans,1 + m);
               }

                }

                
            }
            dp[i] = ans;
        }
        
       return dp[0]; 
    }
}