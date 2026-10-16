class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for(int i = n-2;i>=0;i--){
            boolean m = false;
            for(int j =1;j<=nums[i];j++){
                if(i + j <= n-1){
                m |=dp[i+j];
                }

                
            }
            dp[i] = m;
        }
        
       return dp[0];
    }
}
