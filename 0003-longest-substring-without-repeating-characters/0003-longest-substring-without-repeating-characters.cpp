class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int max_length = 0;
    int left = 0;
    int right = 0;
    std::unordered_set<char> seen_chars;

    while (right < s.size()) {
        if (seen_chars.find(s[right]) == seen_chars.end()) {
            seen_chars.insert(s[right]);
            max_length = std::max(max_length, right - left + 1);
            right++;
        } else {
            seen_chars.erase(s[left]);
            left++;
        }
    }

    return max_length;
    }
};