
import java.util.*;

class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        fun(0, s, new ArrayList<>());
        return ans;
    }

    void fun(int index, String s, List<String> path) {
        // Base case
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);

            if (isPalindrome(sub)) {
                path.add(sub);

                fun(i + 1, s, path);

                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
