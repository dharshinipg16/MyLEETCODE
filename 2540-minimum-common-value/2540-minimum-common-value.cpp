class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> frequencyMap;
        for (int num : nums1) {
            frequencyMap[num]++;
        }
        for (int num : nums2) {
            if (frequencyMap[num] > 0) {
                return num;
            }
        }
        return -1;
    }
};
