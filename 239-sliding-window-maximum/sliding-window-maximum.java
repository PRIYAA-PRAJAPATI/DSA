import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]) {
                dq.pollLast();
            }
            dq.addLast(j);
            if (j - i + 1 == k) {
                ans[i] = nums[dq.peekFirst()];
                if (dq.peekFirst() == i) {
                    dq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}