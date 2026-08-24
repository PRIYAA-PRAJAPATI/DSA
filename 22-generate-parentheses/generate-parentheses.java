import java.util.*;

class Solution {
    
    List<String> ans = new ArrayList<>();

    void fun(String s, int n, int a, int b) {
        
        // More closing brackets than opening brackets
        if (b > a) return;

        // Too many brackets
        if (a > n || b > n) return;

        // Complete valid string
        if (s.length() == 2 * n) {
            ans.add(s);
            System.out.print(s + " ");
            return;
        }

        // Pick '('
        fun(s + "(", n, a + 1, b);

        // Pick ')'
        fun(s + ")", n, a, b + 1);
    }

    public List<String> generateParenthesis(int n) {
        fun("", n, 0, 0);
        return ans;
    }
}