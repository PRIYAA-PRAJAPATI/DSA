import java.util.*;

class Solution {

    public void fun(int s,
                    ArrayList<Integer> nums,
                    ArrayList<Integer> tmp,
                    List<List<Integer>> ans,
                    int target,
                    HashMap<ArrayList<Integer>, Integer> m1) {

        if (s > target)
            return;

        if (s == target) {

            if (!m1.containsKey(tmp)) {
                ans.add(new ArrayList<>(tmp));
                m1.put(new ArrayList<>(tmp), 1);
            }

            return;
        }

        for (int i = 0; i < nums.size(); i++) {

            ArrayList<Integer> ip = new ArrayList<>(nums);

            // Skip duplicate elements
            if (i > 0 && nums.get(i).equals(nums.get(i - 1)))
                continue;

            // Remove elements from 0 to i
            for (int j = 0; j <= i; j++)
                ip.remove(0);

            // Pick
            tmp.add(nums.get(i));

            // Recursive call
            fun(s + nums.get(i), ip, tmp, ans, target, m1);

            // Backtrack
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> input = new ArrayList<>();

        for (int x : nums)
            input.add(x);

        // Sort
        Collections.sort(input);

        ArrayList<Integer> tmp = new ArrayList<>();

        HashMap<ArrayList<Integer>, Integer> m1 = new HashMap<>();

        fun(0, input, tmp, ans, target, m1);

        return ans;
    }
}