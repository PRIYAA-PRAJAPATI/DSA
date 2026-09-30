class Solution {
    int[] nums;
    int[][] dp;
    boolean fun(int i, int t, int s) {
        // Found target
        if (s == t)
            return true;
        // S cross t
        if (s > t)
            return false;
        // No elements left
        if (i == nums.length)
            return false;
        if (dp[i][s] != -1)
            return dp[i][s] == 1;
        boolean take = fun(i + 1, t, s + nums[i]); // Take  
        boolean nottake = fun(i + 1, t, s); // Not Take
        boolean ans = take || nottake;  
        dp[i][s] = ans ? 1 : 0;// Store answer

        return ans;
    }

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        // Odd total cannot be divided equally
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, target, 0);
    }
}