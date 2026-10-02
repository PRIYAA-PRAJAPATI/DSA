class Solution {
    int[] dp;
     int fun(int i, int[] cost) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
     
        int c1 = fun(i + 1, cost); //for 1 step
        int c2 = fun(i + 2, cost); //for 2 step

        // Current cost + minimum of both choices
        dp[i] = cost[i] + Math.min(c1, c2);

        return dp[i];
     }
     public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        int c1 = fun(0, cost);
        int c2 = fun(1, cost);

        return Math.min(c1, c2);
    }
}