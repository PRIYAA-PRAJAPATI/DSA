class Solution {
    int[][] dp;
    int fun(int i ,int j,int[] nums1 ,int[] nums2 ){
        int n = nums1.length;
        int m = nums2.length;
        if(i>=n||j>=m)
        return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(nums1[i]==nums2[j]){
            return dp[i][j]= 1+fun(i+1,j+1,nums1,nums2);
        }
        else{
            int c1 = fun(i+1,j,nums1,nums2);
            int c2 = fun(i,j+1,nums1,nums2);
           return dp[i][j]=Math.max(c1,c2);
        }
      
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
         int n = nums1.length;
        int m = nums2.length;
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(0,0,nums1,nums2);
        
    }
}