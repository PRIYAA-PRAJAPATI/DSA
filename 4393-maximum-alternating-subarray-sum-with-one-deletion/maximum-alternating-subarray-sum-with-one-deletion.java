class Solution {
    static long dp[][][][];
    public long maxAlt(int nums[],int i,int s,int p,int sg){
        if(i >= nums.length) {
            if(s == 0) return Long.MIN_VALUE;
            else return 0;
        }
       long curr =1L* sg * nums[i];
      long ans = Long.MIN_VALUE;
     if(dp[i][s][p][sg+1] != Long.MIN_VALUE) return dp[i][s][p][sg+1];
       if(s == 0){
        long c1 = maxAlt(nums,i+1,s,p,sg);
        ans = Math.max(ans,c1);
        long c2 = curr +  maxAlt(nums,i+1,1,p,-sg);
         ans = Math.max(ans,c2);
       }else{
        long c1 = curr + maxAlt(nums,i+1,s,p,-sg);
         ans = Math.max(ans,0L);
        if(p == 1){
            long c2 = maxAlt(nums,i+1,s,0,sg);
             ans = Math.max(ans,c2);
        }
        ans = Math.max(ans,c1);
       }
     
     return dp[i][s][p][sg+1] = ans;
    }
    public long maxAlternatingSum(int[] nums) {
       dp = new long[nums.length+1][3][3][3];
       for(long e[][][]:dp){
        for(long d[][]:e){
            for(long t[]:d) Arrays.fill(t,Long.MIN_VALUE);
        }
       }
       return maxAlt(nums,0,0,1,1); 
    }
}