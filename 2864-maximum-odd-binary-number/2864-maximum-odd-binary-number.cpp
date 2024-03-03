class Solution {
public:
    string maximumOddBinaryNumber(string s) {
        int n = s.length();
        // Find the index of the rightmost '1'
        int last_one = n - 1;
        while (last_one >= 0 && s[last_one] == '0') {
            last_one--;
        }
        // If 'last_one' is not pointing to the last character, swap the character at 'last_one' with the last character
        if (last_one < n - 1) {
            swap(s[last_one], s[n - 1]);
        }
        // Sort characters from the beginning of the string up to the second last character in non-increasing order
        sort(s.begin(), s.begin() + n - 1, greater<char>());
        // Return the modified string
        return s;
    }
};