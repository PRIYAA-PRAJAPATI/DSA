class Solution {
    int[] dp = new int[1000];
    int fun(int i,int[] days,int[]cost){
        if(i>=days.length)
        return 0;
        if(dp[i] != -1)
        return dp[i];
         
         int one = cost[0] + fun(i+1,days,cost); //day1 pass

         int id1 = days.length;
         
         int id2 = days.length;
          
         for(int j = i+1;j<days.length;j++){
            if(days[j]>=days[i]+7){
                id1 = j;
                break;
            }
         }
            
          
          for(int j = i+1;j<days.length;j++){ //to find 1st day >=nums[i]+30
            if(days[j] >= days[i]+30){
                id2 = j;
                break;
            }
          

    }
    int seven = cost[1]+fun(id1,days,cost); //7day pass
    int thirty = cost[2]+fun(id2,days,cost); //30 
    return dp[i]=Math.min(one,Math.min(seven,thirty)); //min
}
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp,-1);
        return fun(0, days, costs);
        
    }
}