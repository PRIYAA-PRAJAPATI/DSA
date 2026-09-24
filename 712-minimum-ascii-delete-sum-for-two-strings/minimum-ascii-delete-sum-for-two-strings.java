class Solution {
    static int dp[][];
    public int minD(String s1,String s2,int i,int j){
        int minAcc = 0;
        if(i==s1.length()) {
            while(j < s2.length()){
                minAcc +=(int)s2.charAt(j);
                j++;
            }
            return minAcc;
        }
        if(j == s2.length()){
            while(i < s1.length()){
                minAcc +=(int)s1.charAt(i);
                i++;
            }
            return minAcc;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = minD(s1,s2,i+1,j+1);

        }
        int deleteS1 = (int)s1.charAt(i) + minD(s1,s2,i+1,j);
        int deleteS2 = (int)s2.charAt(j) + minD(s1,s2,i,j+1);
        int ans =  Math.min(deleteS1,deleteS2);
        
        return dp[i][j] = ans;
    }
    public int minimumDeleteSum(String word1, String word2) {
         dp = new int[word1.length()][word2.length()];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
       
        
         int ans = minD(word1,word2,0,0);
        return ans;
    }
}