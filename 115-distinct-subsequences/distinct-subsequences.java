
class Solution {
    int[][] dp;
    int fun(int i, int j, String s, String t) {
        if (j == t.length()) {
            return 1;
     }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = fun(i + 1, j, s, t);
        if (s.charAt(i) == t.charAt(j)) {
            ans += fun(i + 1, j + 1, s, t);
        }
        return dp[i][j] = ans;
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(0, 0, s, t);
    }
}