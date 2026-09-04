class Solution {
    int[][] dp;

    public int coinChange(int[] nums, int k) {
        dp = new int[nums.length][k + 1];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = fun(0, nums, 0, k);

        if (ans >= 1000000000)
            return -1;

        return ans;
    }

    int fun(int i, int[] nums, int s, int k) {
        if (k == 0)   // Amount completed
            return 0;

        if (k < 0 || i >= nums.length)// Invalid case
            return 1000000000;

        if (dp[i][k] != -1)
            return dp[i][k];

        int c1 = 1 + fun(i, nums, s, k - nums[i]); // Pick
        int c2 = fun(i + 1, nums, s, k);  // Not pick

        return dp[i][k] = Math.min(c1, c2);
    }
}