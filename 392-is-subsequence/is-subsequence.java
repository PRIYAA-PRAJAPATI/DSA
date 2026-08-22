class Solution {

    boolean fun(int i, int j, String s, String t) {

        if (i >= s.length())
            return true;

        if (j >= t.length())
            return false;

        boolean m = false;

        if (s.charAt(i) == t.charAt(j)) {

            boolean a1 = fun(i + 1, j + 1, s, t);
            m = m | a1;

        } else {

            boolean a2 = fun(i, j + 1, s, t);
            m = m | a2;
        }

        return m;
    }

    public boolean isSubsequence(String s, String t) {
        return fun(0, 0, s, t);
    }
}