class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int or = 0;
                for (int p = i; p <= j; p++) {
                    or = or | nums[p];
                }
                if (or >= k) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        if(minLen == Integer.MAX_VALUE) return -1;
        return minLen;
    }
}