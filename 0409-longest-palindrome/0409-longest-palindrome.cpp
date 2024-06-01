class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char , int>mp;
        for (auto i:s) {
            mp[i]++;
        }
        int ans = 0;
        bool isoddPresent = false;
        for (auto i:mp) {
            if (i.second % 2 == 0) ans+=i.second;
            else {
                ans +=i.second-1;
                isoddPresent = true;
            }
        }
        if (isoddPresent) ans += 1;
        return ans;
    }
};