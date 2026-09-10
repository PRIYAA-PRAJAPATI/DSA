class Solution {
    int[] dp = new int[1000];
    int fun(int i,int[] nums,int[]cost){
        if(i>=nums.length)
        return 0;
        if(dp[i] != -1)
        return dp[i];
         
         int c1 = cost[0] + fun(i+1,nums,cost);

         int id1 = nums.length;
         
         int id2 = nums.length;
          
          int l = i+1;
          int h = nums.length - 1;
          while(l<=h){
            int mid = (l+h)/2;
            if(nums[mid]>=nums[i]+7){
                id1 = mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
          }
          for(int j = i+1;j<nums.length;j++){
            if(nums[j] >= nums[i]+30){
                id2 = j;
                break;
            }
          

    }
    int c2 = cost[1]+fun(id1,nums,cost);
    int c3 = cost[2]+fun(id2,nums,cost);
    return dp[i]=Math.min(c1,Math.min(c2,c3));
}
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp,-1);
        return fun(0, days, costs);
        
    }
}