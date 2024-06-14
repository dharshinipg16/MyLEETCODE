class Solution {
public:
    bool isAcronym(vector<string>& words, string s) {
        int n = words.size();
        string st;
        for(int i=0;i<n;i++)
        {
            st.push_back(words[i][0]);
        }
        if(s == st)
        {
            return true;
        }
        return false;
    }
};