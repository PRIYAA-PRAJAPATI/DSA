class Solution {

    void fun(List<Integer> nums,
             List<Integer> tmp,
             List<List<Integer>> ans,
             Map<List<Integer>, Integer> m1) {

        Collections.sort(tmp);

        if (m1.containsKey(tmp)) {
            return;
        }

        ans.add(new ArrayList<>(tmp));
        m1.put(new ArrayList<>(tmp), 1);

        if (nums.size() == 0) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {

            List<Integer> ip = new ArrayList<>(nums);
            List<Integer> op = new ArrayList<>(tmp);

            op.add(nums.get(i));

            for (int j = 0; j <= i; j++) {
                ip.remove(0);
            }

            fun(ip, op, ans, m1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Map<List<Integer>, Integer> m1 = new HashMap<>();

        List<Integer> input = new ArrayList<>();

        for (int x : nums) {
            input.add(x);
        }

        fun(input, tmp, ans, m1);

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