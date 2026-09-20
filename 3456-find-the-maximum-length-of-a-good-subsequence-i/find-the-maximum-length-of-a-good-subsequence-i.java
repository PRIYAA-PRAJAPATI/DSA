class Solution {

    int[][][] dp;

    int fun(int i, int[] nums, int p, int k) {

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][p + 1][k] != -1) {
            return dp[i][p + 1][k];
        }

        int m = 0;

        // Take current element if:
        // 1. There is no previous element
        // 2. Current element == previous element
        if (p == -1 || nums[i] == nums[p]) {

            int a = 1 + fun(i + 1, nums, i, k);
            m = Math.max(m, a);
        }

        // Current element is different, but we can use one change
        else if (k > 0) {

            int b = 1 + fun(i + 1, nums, i, k - 1);
            m = Math.max(m, b);
        }

        // Don't take current element
        int c = fun(i + 1, nums, p, k);

        m = Math.max(m, c);

        return dp[i][p + 1][k] = m;
    }

    public int maximumLength(int[] nums, int k) {

        dp = new int[nums.length][nums.length + 1][k + 1];

        // Fill dp with -1
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums.length; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return fun(0, nums, -1, k);
    }
}