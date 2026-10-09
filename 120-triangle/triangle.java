class Solution {
    HashMap<String,Integer> dp = new HashMap<>();
    int fun(int i,int j,List<List<Integer>> grid){
        int n = grid.size();
        if(i>=n)
        return Integer.MAX_VALUE;
        if(i==n-1)return grid.get(i).get(j);
        String key = i+"@"+j;
        if(dp.containsKey(key)){
        return dp.get(key);
    }
        int c1 = fun(i+1,j,grid);
        int c2 = fun(i+1,j+1,grid);
        int ans = grid.get(i).get(j)+Math.min(c1,c2);
        dp.put(key,ans);
        return ans;
    }
    public int minimumTotal(List<List<Integer>> grid) {
        dp = new HashMap<>();
        return fun(0,0,grid);
    }
}