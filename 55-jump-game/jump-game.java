class Solution {
    int[] dp;
    boolean fun(int i,int[] nums){
        if(i >= nums.length-1) return true;
        if(dp[i]!=-1)return dp[i]==1;
    
    for(int j = 1;j<=nums[i];j++){
        if(fun(i+j,nums)){
            dp[i]=1;
            return true;
        }
    }
    dp[i] = 0;
    return false;
    }
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return fun(0,nums);
    }
}