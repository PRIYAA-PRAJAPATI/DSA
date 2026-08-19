class Solution {

    void fun(List<Integer> nums,
             List<Integer> tmp,
             List<List<Integer>> ans) {

        ans.add(new ArrayList<>(tmp));

        if (nums.size() == 0) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {

            List<Integer> ip = new ArrayList<>(nums);
            List<Integer> op = new ArrayList<>(tmp);

            if (i > 0 && nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }

            op.add(nums.get(i));

            for (int j = 0; j <= i; j++) {
                ip.remove(0);
            }

            fun(ip, op, ans);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> input = new ArrayList<>();

        Arrays.sort(nums);

        for (int x : nums) {
            input.add(x);
        }

        fun(input, tmp, ans);

        Collections.sort(ans, (a, b) -> {
            int n = Math.min(a.size(), b.size());

            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }

            return a.size() - b.size();
        });

        return ans;
    }
}