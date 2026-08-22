import java.util.*;

class Solution {

    List<String> ans = new ArrayList<>();

    void fun(int i, String s, StringBuilder tmp, Map<Integer, String> m1) {

        if (i >= s.length()) {
            ans.add(tmp.toString());
            return;
        }

        int curr = s.charAt(i) - '0';
        String str = m1.get(curr);

        for (int j = 0; j < str.length(); j++) {

            tmp.append(str.charAt(j));

            fun(i + 1, s, tmp, m1);

            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public List<String> letterCombinations(String s) {

        Map<Integer, String> m1 = new HashMap<>();

        m1.put(2, "abc");
        m1.put(3, "def");
        m1.put(4, "ghi");
        m1.put(5, "jkl");
        m1.put(6, "mno");
        m1.put(7, "pqrs");
        m1.put(8, "tuv");
        m1.put(9, "wxyz");

        ans.clear();

        if (s.length() == 0)
            return ans;

        fun(0, s, new StringBuilder(), m1);

        return ans;
    }
}