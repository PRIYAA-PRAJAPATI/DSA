class Solution {
    int dp[][];
    public int longest(int arr[][],int i,int prev){
        if(i >= arr.length) return 0;

        if(dp[prev+1][i] != -1) return dp[prev+1][i];
        int skip = longest(arr,i+1,prev);
        int take = 0;
        if(prev == -1 || arr[i][0] > arr[prev][1]) take =  1 + longest(arr,i+1,i);
        return dp[prev+1][i] = Math.max(take,skip);
    }
    public int findLongestChain(int[][] pairs) {
       if(pairs.length == 0) return 0;
        dp = new int[pairs.length+1][pairs.length];
       for(int ele[]:dp){
        Arrays.fill(ele,-1);
       }
       Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        return longest(pairs,0,-1);
    }
}