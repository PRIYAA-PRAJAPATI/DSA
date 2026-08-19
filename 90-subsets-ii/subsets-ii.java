class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    void solve(int[] nums, int start, List<Integer> cur) {

        
        ans.add(new ArrayList<>(cur));

        for (int i = start; i < nums.length; i++) {

            
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            
            cur.add(nums[i]);

            
            solve(nums, i + 1, cur);

            
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        
        Arrays.sort(nums);

        List<Integer> cur = new ArrayList<>();

        solve(nums, 0, cur);

        return ans;
    }
}