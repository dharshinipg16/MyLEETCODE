public class Solution {
    public boolean isPalindrome(String s) {
        String qs = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (Character.isLetter(c)) {
                    qs += Character.toLowerCase(c);
                } else {
                    qs += c;
                }
            }
        }
        StringBuilder reversed = new StringBuilder();
        reversed.append(qs);
        reversed = reversed.reverse();
        return qs.equals(reversed.toString());
    }
}