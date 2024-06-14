class Solution {
    public String finalString(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'i') {
                res.reverse();
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}