class Solution {
    int[][][] dp = new int[101][101][101];
    int fun(int i, int j, char[][] grid, int a) {
        int n = grid.length;
        int m = grid[0].length;
        if (i >= n || j >= m)
            return 0;
        int len = n + m - 1;
        if (grid[i][j] == '(')
            a++;
        else
            a--;
        if (a > len / 2 || a < 0)
            return 0;
        if (i == n - 1 && j == m - 1)
            return a == 0 ? 1 : 0;
        if (dp[i][j][a] != -1)
            return dp[i][j][a];

        int c1 = fun(i + 1, j, grid, a);
        int c2 = fun(i, j + 1, grid, a);
        return dp[i][j][a] = c1 | c2;
    }
    public boolean hasValidPath(char[][] grid) {

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return fun(0, 0, grid, 0) == 1;
    }
}