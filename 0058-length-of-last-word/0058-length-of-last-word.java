class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count != 0 && s.charAt(i) == ' ') {
                return count;
            } else {
                if (s.charAt(i) != ' ') {
                    count++;
                }
            }
        }
        return count;
    }
}
