import java.util.*;

class Solution {

    static ArrayList<Long> even = new ArrayList<>();
    static ArrayList<Long> odd = new ArrayList<>();
    static boolean done = false;

    static void fun() {

        for (long i = 1; i <= 100000; i++) {

            String s = Long.toString(i);
            String t = new StringBuilder(s).reverse().toString();

            long a = Long.parseLong(s + t);
            long b = Long.parseLong(s + t.substring(1));

            if (a <= 2000000002L) {
                if (a % 2 == 0)
                    even.add(a);
                else
                    odd.add(a);
            }

            if (b <= 2000000002L) {
                if (b % 2 == 0)
                    even.add(b);
                else
                    odd.add(b);
            }
        }

        Collections.sort(even);
        Collections.sort(odd);
    }

    public long minOperations(int[] nums) {

        if (!done) {
            fun();
            done = true;
        }

        long k = 0;

        for (int a : nums) {

            ArrayList<Long> v;

            if (a % 2 == 0)
                v = even;
            else
                v = odd;

            int l = 0;
            int h = v.size() - 1;

            int ans = v.size();

            // Binary Search
            while (l <= h) {

                int mid = (l + h) / 2;

                if (v.get(mid) >= a) {
                    ans = mid;
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            long mm = Long.MAX_VALUE;

            if (ans < v.size()) {
                mm = Math.min(
                    mm,
                    Math.abs(v.get(ans) - (long)a) / 2
                );
            }

            if (ans > 0) {
                mm = Math.min(
                    mm,
                    Math.abs(v.get(ans - 1) - (long)a) / 2
                );
            }

            k += mm;
        }

        return k;
    }
}