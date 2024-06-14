class Solution {
public:
    int sumIndicesWithKSetBits(vector<int>& nums, int k) {
        int sz = nums.size();
        long sum = 0, ctr = 0, j; // Initialize sum, ctr, and j variables
        for (int i = 0; i < sz; i++) {
            j = i; // Store current index i in j (to avoid modifying i directly)
            ctr = 0; // Reset counter for set bits
            while (j > 0) {
                ctr += j & 1; // Add 1 to ctr if the least significant bit of j is 1
                j = j >> 1; // Right shift j by 1 bit to check the next bit
                cout << ctr << j; // Output the current count of set bits and the updated value of j (for debugging)
            }
            if (ctr == k) { // Check if the count of set bits equals k
                sum = sum + nums[i]; // Add nums[i] to sum if the condition is met
            }
        }
        return sum; // Return the final sum
    }
};
