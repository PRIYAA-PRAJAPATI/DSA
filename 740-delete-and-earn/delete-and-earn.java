import java.util.*;

class Solution {

    int[] dp = new int[20005];

    int fun(int i, ArrayList<Integer> nums, HashMap<Integer, Integer> m1) {

        if (i == nums.size() - 1) {
            int x = nums.get(i);
            return x * m1.get(x);
        }

        if (i >= nums.size()) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int m = 0;

        int curr = nums.get(i);
        int currentCost = curr * m1.get(curr);

        
        if (i + 1 < nums.size() &&
            nums.get(i + 1) == curr + 1) {

            int a = currentCost + fun(i + 2, nums, m1);
            m = Math.max(m, a);
        }

       
        if (i + 1 < nums.size() &&
            nums.get(i + 1) != curr + 1) {

            int a = currentCost + fun(i + 1, nums, m1);
            m = Math.max(m, a);
        }

        
        int a = fun(i + 1, nums, m1);
        m = Math.max(m, a);

        return dp[i] = m;
    }

    public int deleteAndEarn(int[] nums) {

        HashMap<Integer, Integer> m1 = new HashMap<>();

       
        for (int x : nums) {
            m1.put(x, m1.getOrDefault(x, 0) + 1);
        }

        ArrayList<Integer> v1 = new ArrayList<>(m1.keySet());

       
        Collections.sort(v1);

        Arrays.fill(dp, -1);

        return fun(0, v1, m1);
    }
}